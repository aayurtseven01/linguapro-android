# LinguaPro Android

Kotlin + Jetpack Compose ile hazırlanmış, Türkçe arayüzlü, oyunlaştırılmış dil öğrenme uygulaması.
İngilizce için A1–C2 genişletilmiş müfredat; Almanca, Fransızca, İspanyolca, Portekizce, İtalyanca,
Rusça, Çince, Japonca ve Korece için A1–C2 yapılandırılmış kurslar (10 öğrenim dili).

## Öne çıkanlar

- **Duolingo tarzı kıvrımlı patika:** her ders bir düğüm, Checkpoint kupaları, nabız atan mevcut ders; LazyColumn ile tembel oluşturma.
- **Oyunlaştırma:** KOMBO sayacı ve "Üst üste N!" kutlamaları, günlük görevler + XP ödülleri, XP→seviye (Lv) sistemi.
- **Topluluk:** XP lig tablosu, kullanıcı adıyla arkadaş arama/ekleme (rezervasyonlu benzersiz adlar), arkadaş başarılarının aktığı Bülten.
- **Avatar motoru:** cinsiyet/ten/saç/göz/gözlük/kıyafet seçimiyle parametrik (varlıksız) avatar; profilde, ligde, bültende ve ders karakterlerinde kullanılır.
- **Ders deneyimi:** soruları sunan 6 kişilik karakter kadrosu (konuşma balonu), kelime bankalı boşluk doldurma, 2×2 seçenek kareleri, parçalı ilerleme, lime/pembe geri bildirim panelleri, konfeti, sentezlenmiş "pluck" sesleri ve uygulama geneli dokunma kliki (🔊 ile kapatılabilir), sonuç halkası + XP sayacı.
- **Tekrar sistemleri:** Günlük Tekrar (10 soruluk karışım), Günün 5 Kelimesi (öğren → ertesi gün tekrar; havuzlar Goethe/DELF–DALF/DELE/CAPLE/CILS/TORFL/HSK/JLPT/TOPIK/Oxford kademeleriyle hizalı, dil başına 240–286 kelime), EN tarafında SM-2 aralıklı tekrar kartları.
- **Seviye belirleme:** 18 soru (her CEFR seviyesinden 3), seviye başına 2/3 geçme ölçütü, C2'ye kadar atama; sonuçta "belirlenen seviyeden başla / A1'den temelden başla" seçimi.
- **Checkpoint barajı:** ünite sonu sınavında %80 altı ilerletmez; "Yeniden dene" ile tam sıfırlanmış tekrar.
- **Hesap ve veri silme (Google Play uyumlu):** uygulama içinden; Firestore profil + ders geçmişi + lig kaydı + arkadaşlar + bülten paylaşımları + Authentication hesabı zincirle temizlenir.

## Derleme

Android Studio ile açıp Gradle senkronizasyonunu tamamlayın. **JDK 17** ve **Android SDK 35** gerekir.
minSdk 24, targetSdk 35, paket adı `com.linguapro.android`.

```bash
./gradlew assembleDebug
# APK: app/build/outputs/apk/debug/app-debug.apk
```

CI (GitHub Actions) her push'ta birim testleri + Firestore kural testlerini koşar, debug APK'yı Releases'a yükler.
`versionCode`/`versionName` CI çalıştırma numarasından türetilir (yerelde 1 / 1.1.0 kalır).

## Mimari

Compose + tip güvenli Navigation; Hilt; Room (ders/tekrar kartı tabloları, SM-2 planlayıcı); DataStore (ayarlar);
SharedPreferences (XP/seri, kurs dili/seviye ilerlemesi — uid'ye bağlı anahtarlar); Firebase Auth + Firestore
(profil, ders olayları, lig/bülten/arkadaş/kullanıcı adı koleksiyonları — kuralları `firestore.rules`,
testleri `tests/firestore-rules`). TTS ders diline göre konuşur; konuşma tanıma sessiz SpeechRecognizer ile çalışır
(telaffuz puanı değildir). Cevap denetimi: olumsuzluk uyuşmazlığı reddi + LCS tabanlı sıra duyarlı eşleşme +
CJK için karakter-ikilisi benzerliği.

## Bilinen sınırlar / üretim öncesi yapılacaklar

- Play Billing bağlı değil; plan ekranı bilgilendirme amaçlı, satın alma başlatmaz.
- Lig XP'si istemci beyanıdır (kurallar tip/aralık doğrular); sunucu doğrulamalı XP artışı backlog'dadır.
- Release imzalama/minify/çökme raporlama yapılandırılmadı (dağıtım debug APK).
- Kurs içeriği Kotlin kaynaklarındadır; JSON'a taşıma backlog'dadır. Dünya dilleri müfredatı yapılandırılmış ve
  otomatik bütünlük testlerinden geçmiş olsa da ana dili konuşan editör incelemesinden geçmemiştir.
- UI testi ve cihaz üstü DB migration testi yoktur (birim + kural testleri CI'da).
- `MainActivity.kt` büyüktür; ekran başına paket bölme planlanmaktadır.
