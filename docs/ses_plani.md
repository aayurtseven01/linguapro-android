# Ses Stratejisi — Duolingo Kalitesine Giden Yol

## Bugün uygulamada olan
Karakter ses profilleri: 6 ders karakteri + 2 hikâye karakteri, her biri kendine özgü
perde/hız TTS profiliyle konuşur (ör. gözlüklü karakter pes ve ağır, topuzlu karakter tiz).
Maliyet: 0 ₺, çevrimdışı çalışır, 10 dilde geçerli. 🔊 düğmesi tüm sesleri (tıklama + konuşma)
yönetir; kapalıyken hiçbir ses çalmaz.

## Faz S2 — Stüdyo kalitesi: Cloud TTS ön-üretim hattı (UYGULANDI)
Tüm konuşabilir metinler — 5.089 ders + 11 hikâye taramasından **3.929 benzersiz metin**
(~118 bin karakter; egzersizler şablonlu olduğu için devasa tekrar-indirgeme var) — Google
Cloud Text-to-Speech **Neural2/WaveNet** sesleriyle TOPLU üretilir, MP3'ler Firebase
Storage'a konur; uygulama **yerel önbellek → CDN → cihaz TTS** sırasıyla çalar.

- Maliyet: Neural2/WaveNet aylık ilk 1M karakter ücretsiz → bu katalog (~190 bin karakter,
  EN iki aksan dahil) **ücretsiz kota içinde**; içerik güncellemesinde fark kadar.
- Dil başına 2 ses (♀+♂) otomatik seçilir (Neural2 önce, yoksa WaveNet); EN'de her iki aksan
  (en-US + en-GB) üretilir, kullanıcı aksan ayarına uygundur. Karakter eşlemesi korunur:
  pes karakterler erkek, tiz karakterler kadın stüdyo sesiyle konuşur.
- Dosya adı `sha256("ses|metin")` → metin/ses değişmedikçe yeniden üretim yok. 404 dönen
  metinler oturum boyunca negatif önbelleğe alınır (tekrar bekletmez), cihaz TTS'sine düşer.
- **Önbellek**: cihazda `filesDir/audio_cache` (64 MB LRU). Ders ekranı bu etkinliğin ve
  sıradaki etkinliğin sesini önceden indirir; dokunma anında anında çalar.
- Ses hızı ayarı (Ayarlar) uzak seste de geçerlidir (MediaPlayer playbackParams).
- Uygulama katalog bulunamazsa (dağıtım öncesi / çevrimdışı ilk açılış) tamamen mevcut
  cihaz-TTS davranışına döner — altyapı tamamıyla geriye uyumlu.

### Kurulum ve üretim ( kullanıcı tarafı, tek seferlik )
`tools/tts/README.md` içindeki kesin gcloud komutları: **(0)** Storage kovasını açma
(Firebase Console → Storage → "Get started", henüz hiç açılmamışsa) + TTS API etkinleştirme +
`tts-writer` servis hesabı + anahtar, sonra `node tools/tts/generate.mjs --key tools/tts/anahtar.json`.
Script kova yokluğunu, API kapalılığını ve geçersiz anahtarı en başta yakalar ve net mesaj verir.
Katalog Storage'a yazıldığı anda uygulama stüdyo seslerini otomatik kullanır (ekrana özel
bayrak/yapılandırma gerekmez; katalog 24 saatte bir arka planda tazelenir).

### Teknik düzen (uygulama içi)
- `audio/RemoteAudio.kt` — `AudioKey` (normalize+sha256, üretim script'iyle birebir aynı;
  RemoteAudioTest'te sabit değerle kilitli), `RemoteVoiceCatalog` + çözümleme
  (birebir etiket → temel dil yedeği, ör. pt-PT→pt-BR), `AudioCache` (LRU).
- `audio/RemoteSpeechPlayer.kt` — önbellek→CDN→TTS sırası, 404 negatif önbelleği,
  katalog deposu (bellek + SharedPreferences, 24s TTL), MediaPlayer çalma + hız ayarı.
- Entegrasyon: `LearningLessonScreen` (dinleme/konuşma düğmeleri, kelime eşleştirme,
  ön-yükleme, 🔊 ana düğmesi artık konuşmayı da keser) ve `StoryScreens` (replikler;
  otomatik seslendirme artık ses kapalıyken çalmaz — önceki davranış hatası kapatıldı).
- `texts.json` üretimi: içerik Kotlin'de üretildiği için katalog `CourseCatalog` +
  `WorldCatalog` + `StoryCatalog` gezilerek çıkarılır (ExportMain; CI dışı araç).

## Faz S3 — Karakter kimliği (opsiyonel, premium his)
ElevenLabs vb. ile karakter başına özgün ses klonu (≈5$/ay başlangıç). Yalnız hikâyeler ve
karakter balonları için; egzersiz sesleri Faz S2'de kalır.
