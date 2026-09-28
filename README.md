# LinguaPro Android

Kotlin + Jetpack Compose ile hazırlanmış, Türkçe arayüzlü İngilizce öğrenme uygulaması MVP'si.

## Ekran akışı

1. Karşılama
2. Hesap oluşturma (şimdilik arayüz/prototip)
3. Üyelik planı ve 7 günlük deneme bilgilendirmesi
4. Kolaydan zora ilerleyen 12 soruluk seviye belirleme
5. Sonuç seviyesine özel ana sayfa ve ayrı A1, A2, B1, B2, C1 ünite planları
6. Ders/konuşma pratiği örnek ekranı

## Android Studio'da açma

Projeyi Android Studio'da açıp Gradle senkronizasyonunu tamamlayın. JDK 17 ve Android SDK 35 gerekir. Minimum Android sürümü API 26'dır. Uygulamanın paket adı `com.linguapro.android`.

Komut satırı derlemesi: `./gradlew assembleDebug`

## MVP kapsamı ve üretim öncesi yapılacaklar

Bu sürüm ürün/öğrenme iskeleti ve içerik odaklı bir ders dikey dilimidir. A1–C1 için küçük seed dersleri bulunur; bunlar tam CEFR kursu değildir. Ders ekranında TTS ile örnek ses, sistem konuşma tanıma ile sınırlı konuşma denemesi, okuma, gramer, kelime ve yazma etkinliği akışları vardır. Konuşma tanıma telaffuz puanı değildir; açık uçlu yazı için otomatik gramer değerlendirmesi henüz yoktur.

Hesap oluşturma henüz Firebase'e kayıt yapmaz; Google Play ödemesi/gerçek 7 günlük deneme, sunucu tarafı abonelik doğrulaması ve kullanıcı ilerlemesinin cihazlar arasında senkronizasyonu henüz bağlı değildir. Firebase projesi yapılandırması ve `app/google-services.json` gereklidir. Ücret/deneme koşulları Play Billing ve sunucu tarafı satın alma doğrulamasıyla gerçek ürün yapılandırmasına göre uygulanmalıdır.

Her seviyenin kendine ait ayrı öğrenme ünite listesi `MainActivity.kt` içindeki `curriculum` haritasındadır. Seviye testi A1 sorularından başlar, doğru yanıt geldikçe ileri düzey sorulara geçer ve ilk yanlış yanıt sonrası yerleştirme sonucunu üretir.
