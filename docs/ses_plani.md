# Ses Stratejisi — Duolingo Kalitesine Giden Yol

## Bugün uygulamada olan (bu commit)
Karakter ses profilleri: 6 ders karakteri + 2 hikâye karakteri, her biri kendine özgü
perde/hız TTS profiliyle konuşur (ör. gözlüklü karakter pes ve ağır, topuzlu karakter tiz).
Maliyet: 0 ₺, çevrimdışı çalışır, 10 dilde geçerli.

## Faz S2 — Stüdyo kalitesi: Cloud TTS ön-üretim hattı (önerilen)
Tüm cümleler (≈16 bin egzersiz sesi + hikâyeler ≈ 500-600 bin karakter) Google Cloud
Text-to-Speech **Neural2/WaveNet** sesleriyle TOPLU üretilir, MP3'ler Firebase Storage/CDN'e konur;
uygulama önce yerel önbellek → CDN → cihaz TTS sırasıyla çalar.

- Maliyet: Neural2 ~16$/1M karakter → tüm katalog **~10-15$ TEK SEFERLİK**; içerik güncellemesinde fark kadar.
- Dil başına 2 ses seçilir (kadın+erkek) → karakter eşlemesi korunur.
- Gerekenler (senin tarafın): GCP projesinde Text-to-Speech API + faturalama; bana bir
  servis hesabı anahtarı (yalnız TTS yetkili) → üretim scriptini ben yazar, sesleri üretir,
  Storage'a yükler, uygulamayı remote-audio'ya bağlarım.

## Faz S3 — Karakter kimliği (opsiyonel, premium his)
ElevenLabs vb. ile karakter başına özgün ses klonu (≈5$/ay başlangıç). Yalnız hikâyeler ve
karakter balonları için; egzersiz sesleri Faz S2'de kalır.
