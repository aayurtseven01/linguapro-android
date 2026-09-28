# LinguaPro Android

Kotlin + Jetpack Compose ile hazırlanmış, Türkçe arayüzlü İngilizce öğrenme uygulaması MVP'si.

## Ekran akışı

1. Karşılama
2. Firebase Email/Password ile kayıt/giriş ve şifre sıfırlama (Firebase hazır değilse açıkça etiketlenmiş demo akışı)
3. Aylık/yıllık plan taslağı ve 7 günlük deneme bilgilendirmesi (demo; satın alma başlatılmaz)
4. Kolaydan zora ilerleyen 12 soruluk seviye belirleme
5. Sonuç seviyesine özel ana sayfa ve ayrı A1, A2, B1, B2, C1 ünite planları
6. Ders/konuşma pratiği örnek ekranı

## Android Studio'da açma

Projeyi Android Studio'da açıp Gradle senkronizasyonunu tamamlayın. JDK 17 ve Android SDK 35 gerekir. Minimum Android sürümü API 26'dır. Uygulamanın paket adı `com.linguapro.android`.

Komut satırı derlemesi: `./gradlew assembleDebug`

## MVP kapsamı ve üretim öncesi yapılacaklar

Bu sürüm ürün/öğrenme iskeleti ve içerik odaklı ders dikey dilimidir. Güncel katalogda A1 için 7, A2–C1 seviyelerinin her biri için 5 tematik ünite ve toplam 55 özgün kısa ders bulunur; bu içerik genişletilmiş bir başlangıç müfredatıdır, henüz tam CEFR kursu değildir. Ders ekranında TTS ile örnek ses, sistem konuşma tanıma ile sınırlı konuşma denemesi, okuma, gramer, kelime ve yazma etkinlik akışları vardır. Konuşma tanıma telaffuz puanı değildir; açık uçlu yazı için otomatik gramer değerlendirmesi henüz yoktur.

Firebase Auth ve Firestore erişim katmanı eklendi; sağlanan `google-services.json` repo'ya bağlandı. Gerçek kayıt/oturum/profil/ilerleme için Firebase Console'da Email/Password sağlayıcısı ve Firestore'un etkinleştirilmesi, ardından `firestore.rules` kurallarının deploy edilmesi gerekiyor; canlı Firebase projesi henüz uçtan uca doğrulanmadı. Firebase yapılandırması eksikse uygulama demo modunu gösterir; gerçek hesap oluşturmaz. Firestore kuralları Emulator Suite testleri CI'da geçiyor. Google Play ödemesi/gerçek 7 günlük deneme, sunucu tarafı abonelik doğrulaması ve cihazlar arası ilerleme senkronizasyonunun üretim doğrulaması henüz tamamlanmadı. Ücret/deneme koşulları Play Billing ve sunucu tarafı satın alma doğrulamasıyla gerçek ürün yapılandırmasına göre uygulanmalıdır.

Her seviyenin kendine ait ayrı öğrenme ünite listesi `MainActivity.kt` içindeki `curriculum` haritasındadır. Seviye testi A1 sorularından başlar, doğru yanıt geldikçe ileri düzey sorulara geçer ve ilk yanlış yanıt sonrası yerleştirme sonucunu üretir.
