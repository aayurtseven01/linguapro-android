#!/usr/bin/env node
/**
 * LinguaPro — Faz S2 stüdyo sesi üretim hattı (bağımlılıksız Node 18+).
 *
 * Ne yapar:
 *   1. tools/tts/texts.json içindeki benzersiz metinleri okur (ExportMain çıktısı).
 *   2. Google Cloud TTS "voices.list" ile her dil etiketi için en iyi kadın+erkek
 *      sesi seçer (Neural2 önce, yoksa WaveNet).
 *   3. Her (ses, metin) çiftini MP3 olarak üretir (sha256("ses|metin") ilk 40 hex adla),
 *      Firebase Storage kovasına audio/v1/{etiket}/{karmak}.mp3 olarak YÜKLER
 *      (publicRead + 1 yıl önbellek başlığı) ve yerel tools/tts/out altına kopyalar.
 *   4. Uygulamanın okuduğu audio/v1/catalog.json dosyasını yazar.
 *
 * Uygulama bu dosyalar olmadan da çalışır: katalog bulunamayınca cihaz TTS'sine düşer.
 *
 * Kullanım:
 *   node tools/tts/generate.mjs --key /yol/servis-hesabi.json
 *   Ek seçenekler: --texts tools/tts/texts.json --bucket linguapro-ad8c7.appspot.com
 *                  --out tools/tts/out --langs DE,FR --dry-run --fresh --concurrency 6
 */

import { createHash, createSign } from 'node:crypto';
import { existsSync, mkdirSync, readFileSync, statSync, writeFileSync } from 'node:fs';
import { dirname, join } from 'node:path';
import { fileURLToPath } from 'node:url';

const HERE = dirname(fileURLToPath(import.meta.url));

// ---------- CLI ----------
const args = process.argv.slice(2);
function arg(name, fallback) {
  const i = args.indexOf(`--${name}`);
  if (i === -1) return fallback;
  const v = args[i + 1];
  return v && !v.startsWith('--') ? v : true;
}
const KEY_PATH = arg('key');
const TEXTS_PATH = arg('texts', join(HERE, 'texts.json'));
const BUCKET = arg('bucket', 'linguapro-ad8c7.appspot.com');
const OUT_DIR = arg('out', join(HERE, 'out'));
const LANGS = arg('langs', null); // ör. "DE,FR"
const DRY_RUN = args.includes('--dry-run');
const FRESH = args.includes('--fresh');
const CONCURRENCY = parseInt(arg('concurrency', '6'), 10);

if (!KEY_PATH || KEY_PATH === true) {
  console.error('HATA: --key /yol/servis-hesabi.json gerekli (bkz. docs/ses_plani.md).');
  process.exit(1);
}

// Uygulama tarafıyla ortak sabitler (bkz. app/.../audio/RemoteAudio.kt — RemoteAudioTest ile kilitli)
const KEY_LEN = 40;
const WS = /[ \t\n\r\f\u000B]+/g;
const normalize = (t) => String(t).trim().replace(WS, ' ');
const audioKey = (voiceId, text) =>
  createHash('sha256').update(`${voiceId}|${normalize(text)}`, 'utf8').digest('hex').slice(0, KEY_LEN);

// Dil kodu → konuşma etiketleri (EN: her iki aksan). Etiket → TTS ses dili takma adları.
const LANG_TAGS = {
  EN: ['en-US', 'en-GB'],
  DE: ['de-DE'],
  FR: ['fr-FR'],
  ES: ['es-ES'],
  PT: ['pt-PT'],
  IT: ['it-IT'],
  RU: ['ru-RU'],
  ZH: ['zh-CN'],
  JA: ['ja-JP'],
  KO: ['ko-KR'],
};
const TAG_ALIASES = {
  'zh-CN': ['cmn-CN', 'zh-CN'],
  'pt-PT': ['pt-PT', 'pt-BR'],
};

// ---------- Google kimlik doğrulama (JWT RS256 → OAuth2 access token) ----------
const saKey = JSON.parse(readFileSync(KEY_PATH, 'utf8'));
if (!saKey.client_email || !saKey.private_key) {
  console.error('HATA: --key dosyası geçerli bir Google servis hesabı JSON anahtarı değil.');
  process.exit(1);
}
const PROJECT = saKey.project_id || 'linguapro-ad8c7';
const b64url = (buf) => Buffer.from(buf).toString('base64url');
let accessToken = null;
let tokenExp = 0;
async function getToken() {
  if (accessToken && Date.now() < tokenExp - 60_000) return accessToken;
  const iat = Math.floor(Date.now() / 1000);
  const header = b64url(JSON.stringify({ alg: 'RS256', typ: 'JWT' }));
  const claims = b64url(JSON.stringify({
    iss: saKey.client_email,
    scope: 'https://www.googleapis.com/auth/cloud-platform',
    aud: 'https://oauth2.googleapis.com/token',
    exp: iat + 3600,
    iat,
  }));
  const input = `${header}.${claims}`;
  const signature = b64url(createSign('RSA-SHA256').update(input).sign(saKey.private_key));
  const res = await fetch('https://oauth2.googleapis.com/token', {
    method: 'POST',
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    body: new URLSearchParams({
      grant_type: 'urn:ietf:params:oauth:grant-type:jwt-bearer',
      assertion: `${input}.${signature}`,
    }),
  });
  if (!res.ok) {
    const body = await res.text();
    if (/invalid_grant|invalid_signature|UNAUTHENTICATED/i.test(body)) {
      throw new Error('Anahtar reddedildi: servis hesabı JSON anahtarı geçersiz veya silinmiş (yeniden üret).');
    }
    throw new Error(`Token alınamadı (${res.status}): ${body.slice(0, 300)}`);
  }
  const j = await res.json();
  accessToken = j.access_token;
  tokenExp = Date.now() + (j.expires_in ?? 3600) * 1000;
  return accessToken;
}

// ---------- HTTP yardımcıları ----------
const sleep = (ms) => new Promise((r) => setTimeout(r, ms));
async function apiFetch(url, init = {}, timeoutMs = 60_000) {
  const ctrl = new AbortController();
  const timer = setTimeout(() => ctrl.abort(), timeoutMs);
  try {
    return await fetch(url, { ...init, signal: ctrl.signal });
  } finally {
    clearTimeout(timer);
  }
}
async function withRetry(fn, tries = 3) {
  let lastErr;
  for (let i = 0; i < tries; i++) {
    try {
      const res = await fn();
      if (res.status >= 500 || res.status === 429) throw new Error(`geçici HTTP ${res.status}`);
      return res;
    } catch (e) {
      lastErr = e;
      await sleep(500 * 2 ** i);
    }
  }
  throw lastErr;
}

// ---------- 1) Ses seçimi ----------
const TYPE_SCORE = { Neural2: 0, WaveNet: 1, Journey: 2, Polyglot: 2, Standard: 3 };
function voiceType(v) {
  return Object.keys(TYPE_SCORE).find((t) => v.name.includes(`-${t}-`)) || null;
}
function pickVoices(allVoices, tag) {
  const aliases = TAG_ALIASES[tag] ?? [tag];
  const eligible = allVoices.filter((v) => {
    if (!v.languageCodes.some((c) => aliases.includes(c))) return false;
    if (v.ssmlGender !== 'FEMALE' && v.ssmlGender !== 'MALE') return false;
    return voiceType(v) != null;
  });
  const byType = (a, b) =>
    (TYPE_SCORE[voiceType(a)] ?? 9) - (TYPE_SCORE[voiceType(b)] ?? 9) || a.name.localeCompare(b.name);
  const female = eligible.filter((v) => v.ssmlGender === 'FEMALE').sort(byType)[0] || null;
  const male = eligible.filter((v) => v.ssmlGender === 'MALE').sort(byType)[0] || null;
  return { f: female, m: male };
}

// ---------- 2) Üretim + yükleme ----------
let aclBlocked = false;
async function synthesize(voice, text) {
  const res = await withRetry(async () =>
    apiFetch('https://texttospeech.googleapis.com/v1/text:synthesize', {
      method: 'POST',
      headers: { Authorization: `Bearer ${await getToken()}`, 'Content-Type': 'application/json' },
      body: JSON.stringify({
        input: { text },
        voice: { languageCode: voice.languageCodes[0], name: voice.name },
        audioConfig: { audioEncoding: 'MP3', speakingRate: 1.0 },
      }),
    }, 60_000)
  );
  if (!res.ok) throw new Error(`TTS ${res.status}: ${(await res.text()).slice(0, 300)}`);
  const j = await res.json();
  return Buffer.from(j.audioContent, 'base64');
}

async function upload(objectPath, bytes, contentType, cacheControl, publicRead) {
  const url =
    `https://storage.googleapis.com/upload/storage/v1/b/${BUCKET}/o` +
    `?uploadType=media&name=${encodeURIComponent(objectPath)}`;
  const headers = {
    Authorization: `Bearer ${await getToken()}`,
    'Content-Type': contentType,
    'Cache-Control': cacheControl,
  };
  if (publicRead) headers['x-goog-acl'] = 'publicRead';
  let res = await withRetry(async () => apiFetch(url, { method: 'POST', headers, body: bytes }, 120_000));
  if (publicRead && (res.status === 400 || res.status === 412)) {
    const body = await res.text();
    if (/uniform|bucket[- ]level|public\s*access\s*prevention/i.test(body)) {
      aclBlocked = true; // kova genel erişim ACL'lerine izin vermiyor
      delete headers['x-goog-acl'];
      res = await withRetry(async () => apiFetch(url, { method: 'POST', headers, body: bytes }, 120_000));
    } else {
      throw new Error(`Storage ${res.status}: ${body.slice(0, 300)}`);
    }
  }
  if (!res.ok) throw new Error(`Storage ${res.status}: ${(await res.text()).slice(0, 300)}`);
  return true;
}

// ---------- Ana akış ----------
async function ensureBucket() {
  const res = await apiFetch(`https://storage.googleapis.com/storage/v1/b/${BUCKET}`, {
    headers: { Authorization: `Bearer ${await getToken()}` },
  }, 15_000);
  if (res.status === 404) {
    console.error(
      `\nHATA: "${BUCKET}" kovası yok — Firebase Storage hiç açılmamış.\n` +
      'Tek adımda aç (biri yeterli):\n' +
      '  a) Firebase Console → Storage → "Get started" → üretim modu\n' +
      `  b) gcloud storage buckets create gs://${BUCKET} --project=${PROJECT}\n` +
      'Sonra bu scripti yeniden çalıştır.'
    );
    process.exit(2);
  }
  if (res.status === 403) {
    // objectAdmin rolü kova üst verisini okuyamaz — kova var olabilir; yükleme zaten hatayı yakalar.
    console.log('Not: Anahtarın kova üst verisi okuma yetkisi yok (normal) — devam ediliyor.');
  }
}

async function main() {
  console.log(`Kova: ${BUCKET}`);
  console.log(`Metinler: ${TEXTS_PATH}`);
  const textsDoc = JSON.parse(readFileSync(TEXTS_PATH, 'utf8'));
  const entries = textsDoc.entries.filter((e) => e.text && e.text.trim());
  const langFilter = LANGS ? String(LANGS).split(',').map((s) => s.trim().toUpperCase()) : null;
  const langs = [...new Set(entries.map((e) => e.lang))].filter((l) => !langFilter || langFilter.includes(l));
  console.log(`Diller: ${langs.join(', ')} — toplam ${entries.length} benzersiz metin`);

  // Ses listesi
  const voicesRes = await apiFetch('https://texttospeech.googleapis.com/v1/voices', {
    headers: { Authorization: `Bearer ${await getToken()}` },
  }, 30_000);
  if (voicesRes.status === 403) {
    console.error(
      '\nHATA: Text-to-Speech API yetkisi yok (403). Muhtemelen API etkin değil:\n' +
      `  gcloud services enable texttospeech.googleapis.com --project=${PROJECT}\n` +
      "(veya Console → API'ler ve Hizmetler → 'Cloud Text-to-Speech API' → Etkinleştir)"
    );
    process.exit(2);
  }
  if (!voicesRes.ok) throw new Error(`voices.list ${voicesRes.status}: ${(await voicesRes.text()).slice(0, 300)}`);
  const allVoices = (await voicesRes.json()).voices || [];
  console.log(`TTS ses havuzu: ${allVoices.length} ses (Neural2 → WaveNet önceliğiyle seçim)`);

  // Kova ön kontrolü (yoksa binlerce hata yerine tek net mesaj)
  await ensureBucket();

  // Etiket → ses çifti
  const tagVoices = {};
  const catalogVoices = {};
  for (const lang of langs) {
    for (const tag of LANG_TAGS[lang] ?? [lang]) {
      const pair = pickVoices(allVoices, tag);
      if (!pair.f || !pair.m) {
        console.warn(`UYARI: ${tag} için kadın/erkek ses bulunamadı — bu etiket atlanır (cihaz TTS'si kullanılır).`);
        continue;
      }
      tagVoices[tag] = { lang, ...pair };
      catalogVoices[tag] = { f: pair.f.name, m: pair.m.name };
      console.log(
        `  ${tag}: ♀ ${pair.f.name}  ♂ ${pair.m.name}`
      );
    }
  }
  if (Object.keys(tagVoices).length === 0) throw new Error('Hiç etiket için ses seçilemedi.');

  // Görev listesi (yerel dosya varsa atla = kaldığı yerden devam)
  const tasks = [];
  for (const e of entries) {
    for (const tag of LANG_TAGS[e.lang] ?? [e.lang]) {
      const tv = tagVoices[tag];
      if (!tv) continue;
      for (const gender of ['f', 'm']) {
        const voice = tv[gender];
        const key = audioKey(voice.name, e.text);
        const localFile = join(OUT_DIR, tag, `${key}.mp3`);
        if (!FRESH && existsSync(localFile) && statSize(localFile) > 0) continue;
        tasks.push({ tag, voice, text: e.text, key, localFile });
      }
    }
  }
  const totalChars = tasks.reduce((s, t) => s + normalize(t.text).length, 0);
  console.log(`Üretilecek: ${tasks.length} ses dosyası (~${totalChars.toLocaleString('tr-TR')} karakter)`);
  console.log(
    `Maliyet notu: Neural2/WaveNet ailelerinde aylık 1.000.000 karakter ücretsizdir; ` +
      `bu katalog muhtemelen ücretsiz kotanın içinde kalır.\n`
  );
  if (DRY_RUN) {
    console.log('--dry-run: üretim yapılmadı.');
    return;
  }

  // İş havuzu
  mkdirSync(OUT_DIR, { recursive: true });
  let done = 0, failed = 0;
  const failures = [];
  const startedAt = Date.now();
  const queue = tasks.slice();
  async function worker() {
    while (queue.length > 0) {
      const t = queue.shift();
      try {
        const mp3 = await synthesize(t.voice, t.text);
        await upload(`audio/v1/${t.tag}/${t.key}.mp3`, mp3, 'audio/mpeg', 'public,max-age=31536000,immutable', true);
        mkdirSync(dirname(t.localFile), { recursive: true });
        writeFileSync(t.localFile, mp3);
        done++;
      } catch (err) {
        failed++;
        failures.push({ tag: t.tag, voice: t.voice.name, text: t.text, error: String(err.message || err) });
      }
      if ((done + failed) % 25 === 0 || queue.length === 0) {
        const pct = (((done + failed) / tasks.length) * 100).toFixed(1);
        console.log(`  ${done + failed}/${tasks.length} (%${pct}) — ✓ ${done}  ✗ ${failed}`);
      }
    }
  }
  await Promise.all(Array.from({ length: Math.max(1, Math.min(CONCURRENCY, 12)) }, worker));

  // Katalog
  const catalogJson = JSON.stringify(
    { version: 1, baseUrl: `https://storage.googleapis.com/${BUCKET}/audio/v1`, voices: catalogVoices },
    null, 2
  );
  if (failed === 0) {
    await upload('audio/v1/catalog.json', Buffer.from(catalogJson), 'application/json', 'public,max-age=3600', true);
    writeFileSync(join(OUT_DIR, 'catalog.json'), catalogJson);
    console.log('\ncatalog.json yüklendi — uygulama stüdyo seslerini otomatik kullanmaya başlar.');
  } else {
    writeFileSync(join(OUT_DIR, 'catalog.json'), catalogJson);
    writeFileSync(join(OUT_DIR, 'failed.json'), JSON.stringify(failures, null, 2));
    console.log(`\n${failed} dosya başarısız — catalog.json YÜKLENMEDİ. ${join(OUT_DIR, 'failed.json')} dosyasına bakıp tekrar çalıştır (kaldığı yerden devam eder).`);
  }

  const secs = ((Date.now() - startedAt) / 1000).toFixed(0);
  console.log(`Bitti: ${done} üretildi, ${failed} hata, ${secs} sn.`);
  if (aclBlocked) {
    console.log(
      '\nDİKKAT: Kova nesne ACL\'lerine izin vermiyor (uniform access / public access prevention).\n' +
      'Uygulamanın seslere erişmesi için kovaya herkese okuma yetkisi ver:\n' +
      `  gcloud storage buckets add-iam-policy-binding gs://${BUCKET} --member=allUsers --role=roles/storage.objectViewer\n` +
      'Bu komut "public access prevention" hatası verirse kovayı Firebase Storage kurallarıyla kullanmak gerekir;\n' +
      'docs/ses_plani.md içindeki alternatife bak.'
    );
    process.exitCode = 2;
  }
}

function statSize(p) {
  try {
    return statSync(p).size;
  } catch {
    return 0;
  }
}

main().catch((e) => {
  console.error('HATA:', e.message || e);
  process.exit(1);
});
