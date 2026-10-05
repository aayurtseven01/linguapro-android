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
CJK için karakterleri koruyan, yalnızca boşluk farkını tolere eden eşleşme. Japonca seslendirme işaretleri ve anlamlı aksanlar korunur.

## Güncel düzeltme ve yayın durumu

- Modern tasarım, dil bazında beceri kayıtları, seviye bazında günlük kelimeler, yerel günlük tarih, yazma uzunluğu kontrolü ve oturum geçmişine göre pratik rotasyonu inceleme dalındadır.
- On dil için A2–C2’de beş ortak senaryonun 50 dil sürümü eklendi; her metinde sekiz replik, Türkçe çeviri ve dört gerekçeli anlama sorusu bulunur. A1 hikâyeleriyle birlikte kütüphane bütün seviyeleri kapsar. Bu kapsam, tüm müfredatın bağımsız CEFR doğrulaması değildir.
- Açık yazma otomatik anlam/dilbilgisi puanı almaz; konuşma eşleştirmesi telaffuz veya serbest diyalog değerlendirmesi değildir.
- Play Billing ve sunucu doğrulaması uygulanmıştır; canlı ödeme ancak `docs/COMMERCIAL_READINESS.md` içindeki sahibi tarafından yapılacak yapılandırma ve gerçek Play testlerinden sonra açılmalıdır.
- Lig puanları sunucuda sınırlandırılır; istemcinin gerçekten bütün soruları yanıtladığı henüz sunucu tarafından kanıtlanmaz.
- Çevrimdışı çalışma zamanı bulutta ayrı, güvenilmeyen geçmiş metadatası olarak korunur; ödüller güvenilir sunucu kabul zamanını kullanır.
- Kullanıcı adı ve bülten yazımları App Check korumalı sunucu fonksiyonları üzerinden yürür. Aynı hesap için tek güncel ad ve günlük beş sabit mesaj sınırı vardır.
- Android cihaz/derleme ve Firestore emülatör kontrolleri geçmeden, imzalı üretim paketi ve canlı ödeme senaryoları doğrulanmadan bu dal satışa hazır sayılmaz.
- Ayrıntılı kabul ölçütleri ve kapanmamış işler: `docs/RELEASE_ACCEPTANCE.md`.
