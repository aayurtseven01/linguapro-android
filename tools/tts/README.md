# Stüdyo Ses Üretim Hattı (Faz S2)

Uygulamanın konuştuğu tüm metinler (**3.929 benzersiz metin**, ~118 bin karakter) Google Cloud
Text-to-Speech **Neural2/WaveNet** sesleriyle bir kez üretilip Firebase Storage'a konur.
Uygulama çalışma sırasında: **yerel önbellek → CDN → cihaz TTS** sırasını izler; katalog
bulunmazsa her şey eskisi gibi cihaz TTS'siyle çalışır, hiçbir şey bozulmaz.

- `texts.json` — üretilecek metinler (`ExportMain` çıktısı; 5.089 ders + 11 hikâye taraması).
- `generate.mjs` — bağımlılıksız Node 18+ script'i: ses seçimi, üretim, yükleme, katalog.

## Bir kez yapılacak kurulum (GCP)

```bash
# 0) Firebase Storage kovası henüz YOKSA önce aç (Console → Storage → "Get started" veya):
gcloud storage buckets create gs://linguapro-ad8c7.appspot.com --project linguapro-ad8c7

# 1) Text-to-Speech API'yi etkinleştir (Console → API'ler → "Cloud Text-to-Speech API" veya):
gcloud services enable texttospeech.googleapis.com --project linguapro-ad8c7

# 2) Yalnız TTS + Storage yetkili servis hesabı ve anahtarı:
gcloud iam service-accounts create tts-writer --project linguapro-ad8c7
gcloud projects add-iam-policy-binding linguapro-ad8c7 \
  --member serviceAccount:tts-writer@linguapro-ad8c7.iam.gserviceaccount.com \
  --role roles/cloudtexttospeech.user
gcloud projects add-iam-policy-binding linguapro-ad8c7 \
  --member serviceAccount:tts-writer@linguapro-ad8c7.iam.gserviceaccount.com \
  --role roles/storage.objectAdmin
gcloud iam service-accounts keys create tools/tts/anahtar.json \
  --iam-account tts-writer@linguapro-ad8c7.iam.gserviceaccount.com
```

(`tools/tts/anahtar*.json` ve `out/` .gitignore'dadır; repoya girmez. Console'dan da
aynı hesap açılıp JSON anahtar indirilebilir.)

## Üretim

```bash
node tools/tts/generate.mjs --key tools/tts/anahtar.json
```

- Dil başına 2 stüdyo sesi (♀+♂) otomatik seçilir; EN için en-US **ve** en-GB üretilir.
- Adresler `sha256("ses|metin")` tabanlıdır → aynı metin ses değişmedikçe yeniden üretilmez.
- Yarım kalırsa **tekrar çalıştır** — `out/` dizinindeki dosyalar atlanır (kaldığı yerden sürer).
- Deneme modu: `--dry-run` (üretmeden planı göster). Tek dil: `--langs DE`.
- Bitince `audio/v1/catalog.json` yüklenir; uygulama bunu görünce stüdyo sesine geçer.

## Maliyet

Neural2/WaveNet ailelerinde **aylık ilk 1.000.000 karakter ücretsiz**; bu katalog ~190 bin
karakter (EN iki aksan dahil) → ücretsiz kota içinde. İçerik eklenirse fark kadar yeniden
üretilir (`texts.json` güncellenip script yeniden koşulur).
