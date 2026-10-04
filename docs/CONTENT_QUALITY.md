# İçerik kalitesi ve editoryal kapsam

Bu belge ürünün içerik durumunu kaydeder; Duolingo ile eşdeğerlik veya CEFR yeterlilik belgesi iddia etmez.

## Uygulanan içerik değişiklikleri

- İngilizce A1-U1 (3 ders), A1-U2 (2), A2-U1 (2), B1-U1 (2), B2-U1 (2), C1-U1 (2), C2-U1 (2): 15 ders tamamen yeniden yazıldı; her birinde 8 etkinlik, 2 hedef kelime ve açık dil bilgisi odağı var.
- Bu 7 ünitenin sınavında öğretim metninin aynısını tekrar etmek yerine yeni bir senaryo kullanılıyor. Toplam 35 yeni sınav sorusu var; bütün sorular seçenekli ve puanlanabilir.
- Diğer dokuz dilin ilk tanışma dersi yeniden yazıldı: Almanca, Fransızca, İspanyolca, Portekizce, İtalyanca, Rusça, Mandarin Çincesi, Japonca ve Korece. Her birinde 8 etkinlik, dinleme senaryosu ve dile özel dil bilgisi açıklaması var. Portekizce dersi Brezilya kullanımını belirtir; Japonca ve Korecede kibar kullanım, Korecede ayrılan/kalan kişiye farklı veda ifadeleri açıklanır. Toplam 24 ders, 192 öğretim etkinliği ve 35 sınav sorusu yeniden yazılmıştır.
- A1 tanışma/aile/rutin, A2 seyahat ve geçmiş olay, B1 iş iletişimi, B2 gerekçe/uzlaşma, C1 kanıt/görüş sentezi, C2 örtük tutum/resmî üslup üzerine çalışır. C2'nin yalnızca deyim ezberi olarak sunulması yerine yorumlama ve üslup seçimi eklenmiştir.
- İngilizce ve diğer dokuz dilde, eski şablonların açıklamasında Türkçe karşılığı bulunan bağlamsız kelime boşluklarına hedeflenen Türkçe anlam eklenir. Örneğin `Ich habe ___ Brüder` tek başına hem zwei hem zehn kabul edebilir; `Anlam: İki erkek kardeşim var` bu belirsizliği giderir. Bu işlem, belirtilen görev sınıfını düzeltir; bütün soruların semantik olarak denetlendiği anlamına gelmez.
- Yazma modelinin cevap alanıyla çeliştiği görevler tutarlı modele bağlanır. Serbest yazı otomatik puanlanmaz ve alternatif ifadeler mümkündür. Konuşma modeliyle eşleşme isteyen görevler açıkça tekrar alıştırması olarak adlandırılır; serbest konuşmanın değerlendirilmiş olduğu izlenimi verilmez.
- Ders kimlikleri, ders sırası ve sunucunun 1.753 derslik izin listesi korunur. Paket ve kelime sürümü artırılarak güncellenen içerik yerel veritabanına yeniden yüklenir; kullanıcıya ait tekrar kartları silinmez.

## Tasarım dayanağı

Avrupa Konseyinin CEFR tanımlayıcıları, öğrenme hedeflerini iletişimsel yapabilme ifadeleriyle ele alır; Companion Volume alımlama, üretim, etkileşim ve arabuluculuk alanlarını içerir. Buradaki seviye eşleştirmeleri editoryal tasarımdır; uzmanlarca kalibre edilmiş bir seviye ölçümü değildir.

- https://www.coe.int/en/web/common-european-framework-reference-languages/cefr-descriptors
- https://book.coe.int/en/education-and-modern-languages/8150-common-european-framework-of-reference-for-languages-learning-teaching-assessment-companion-volume.html

## Doğrulama

`EditorialCurriculumTest`: derslerin gerçek katalogda kullanılması, 15 sabit kimlik, 8 etkinlik, her becerinin bulunması, tek seçenekli cevap anahtarları, yeni sınav metinleri, eski boşlukların anlam ipuçları, yazma model tutarlılığı ve konuşma görev sözleşmesi.

`ClosedQuestionQualityTest` yalnızca cevap anahtarının bir seçenekle eşleşmesini doğrular; başka bir seçeneğin insan değerlendirmesinde de doğru olamayacağını kanıtlamaz. Yeni dersler editoryal olarak okunmuştur; ana dili konuşan öğretmen incelemesinin yerine geçmez.

## Hedefe ulaşmak için kalan içerik çalışması

15 ders dışındaki İngilizce dersler ve diğer dokuz dilin ilk dersinden sonraki müfredatları tamamen yeniden yazılmadı. Şablonlar üzerindeki belirli düzeltmeler bunların uzman onaylı olduğu anlamına gelmez. Tamamlanması gerekenler:

1. Bütün ünitelerde ön koşul, kelime/gramer yükü, öğrenme sırası ve önceki kazanımlara geri dönüş haritası.
2. Her dilde doğal ifade, çeviri, alternatif cevap ve çeldirici incelemesi; yerel dil uzmanı onayı.
3. Özgün konuşmacı sesleri, farklı konuşmacılı diyaloglar, dinleme hızları ve kayıt/çalma doğrulaması. Mevcut sesler cihaz TTS'sidir.
4. Uygulamalı serbest konuşma ve yazma görevleri için ölçütler, güvenilir değerlendirme ve insan incelemesi. Mevcut konuşma tekrar kontrolü telaffuz puanı değildir.
5. Öğrencilerle seviye, öğrenme kazanımı ve tekrar aralığı ölçümleri. Ders sayısı veya testlerin geçmesi öğrenme başarısı kanıtı değildir.

Ticari içerik yeterliliği, bu incelemeler ve kullanıcı çalışmalarından sonra değerlendirilebilir.
