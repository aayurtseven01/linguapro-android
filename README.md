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

Bu ilk sürüm ekran akışını ve seviye/ünite mantığını gösteren bir prototiptir. Hesap oluşturma henüz sunucuya kayıt yapmaz; Google Play ödemesi/gerçek 7 günlük deneme, sunucu tarafı abonelik doğrulaması, sesli telaffuz değerlendirmesi ve kalıcı kullanıcı ilerlemesi henüz bağlı değildir. Ekranlarda prototip olduğu belirtilir. Ücret/deneme koşulları uygulama mağazasına gönderilmeden önce Play Billing ile gerçek ürün yapılandırmasına göre güncellenmelidir.

Her seviyenin kendine ait ayrı öğrenme ünite listesi `MainActivity.kt` içindeki `curriculum` haritasındadır. Seviye testi A1 sorularından başlar, doğru yanıt geldikçe ileri düzey sorulara geçer ve ilk yanlış yanıt sonrası yerleştirme sonucunu üretir.
