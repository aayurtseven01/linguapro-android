# Kurs içeriği ekleme rehberi

Kaynak paket `app/src/main/assets/course_content_v1.json` dosyasıdır. Yeni ünite/ders/kelime eklemek için Kotlin kodu değiştirmek yerine aynı JSON paketine kayıt ekleyin. İçerik uygulama ilk açıldığında veya paketin `contentVersion` değeri artırıldığında doğrulanıp Room'a kurulur.

## Şema

Kök nesne:

```json
{
  "schemaVersion": 1,
  "contentVersion": "1.0.1",
  "units": [
    {
      "id": "B1-JSON-U2",
      "title": "Plans and choices",
      "summary": "Türkçe, kısa ünite açıklaması.",
      "lessons": []
    }
  ]
}
```

Ders şemasında şunlar zorunludur:

- `id`: tüm kurs boyunca kararlı ve benzersiz kimlik; cevap/ilerleme kayıtları bu kimliği kullanır.
- `title`, `canDo`: ders başlığı ve gözlenebilir iletişim hedefi.
- `targetVocabulary`: 8–12 sözcük/kalıp. Her öğede `id`, `termEn`, `translationTr`, `partOfSpeech`, `exampleEn`, `exampleTr`; isteğe bağlı `emoji` bulunur.
- `grammarFocus`: Türkçe açıklama, biçim, İngilizce örnek ve Türkçe karşılığı, Türkçe konuşanlara yönelik yaygın hata notu ve doğru seçenekli kısa kontrol sorusu.
- `stages`: `VOCABULARY`, `GRAMMAR`, `LISTENING`, `READING`, `WRITING`, `SPEAKING` türlerinin her biri tam bir kez.
- `exercises`: kararlı kimlik, `Skill`, Türkçe yönerge/açıklama ve `acceptedAnswers`. Otomatik puanlanmayan yazma/konuşma örnek yanıtını kesin puan gibi sunmayın.

## Seviye ve içerik ilkeleri

- Ünite kimliğinin ilk bölümü CEFR etiketi olmalı: `A1`, `A2`, `B1`, `B2`, `C1` veya `C2`.
- İlk MVP eşiği olarak JSON paketi her seviyede en az iki tam ders içermelidir. Bu, talep edilen 6 ünite × 5 derslik tam kapsamın yerine geçmez.
- Dinleme metni kısa, anlaşılır girdiye uygun ve konuşma model metniyle uyumlu olsun. Okuma metni hedeflenen seviyede anlamlı bir bağlam ve cevabı destekleyen kanıt içersin.
- Türkçe hata notları basit, nazik ve karşılaştırmalı olsun. Article, preposition, söz dizimi, present perfect aktarımı ve sesletim sorunlarını seviye/bağlam içinde planlayın.
- Her eklemede `contentVersion` değerini artırın; içerik kimliklerini değiştirmeyin. Kullanılan medya için lisans/kaynak kaydını yayın sürecinde ayrıca tutun.

## Doğrulama

`CoursePackValidator` şu an temel yapıyı, seviye başına iki ders eşiğini, 8–12 kelimeyi, altı aşamayı, kimlikleri ve doğru dilbilgisi seçeneklerini test eder. Değişiklikten sonra:

```bash
./gradlew testDebugUnitTest assembleDebug
```

Bu testler CEFR düzeyinde uzman öğretmen değerlendirmesinin yerini tutmaz. JSON şablonundaki örnekler MVP seed içeriğidir; yayın öncesi öğretmen/dilbilim incelemesi ve telif kontrolü gerekir.
