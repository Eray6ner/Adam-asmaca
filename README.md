# 🎮 Adam Asmaca (Java Swing)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-Desktop_App-blue?style=for-the-badge)
![NetBeans](https://img.shields.io/badge/NetBeans-IDE-1B6AC6?style=for-the-badge)

Bu proje, NetBeans GUI Builder (JFrame Form) kullanılarak Java Swing ile geliştirilmiş masaüstü kelime tahmin oyunudur. Geleneksel adam asmaca oyununa modern bir arayüz, loglama sistemi ve dinamik kelime havuzu entegre edilmiştir.

## 🚀 Oyunda Neler Var?

* **Dinamik Tahmin Sistemi:** Klasik alfabe butonları yerine, klavye odaklı harf ve kelime tahmini için ayrı metin kutuları (TextField) kullanılır.
* **Şifreli Güvenlik & Loglama:** Program açılırken şifre kontrolü yapılır. Oynanan oyunların süreleri, sonuçları ve logları tablo halinde tutulur. Eski kayıtları temizlemek için yönetici şifresi gerekir.
* **Görsel Geri Bildirim:** Yanlış tahmin sayısına göre değişen dinamik darağacı görselleri ve geçen süreyi gösteren canlı sayaç.
* **Tema Desteği:** Kullanıcı deneyimini artıran Karanlık Mod (Dark Mode) / Aydınlık Mod geçiş butonu.

## 🛠️ Kullanılan Teknolojiler & Swing Parçaları

Arayüz geliştirilirken standart Java Swing kütüphanelerinden yararlanılmıştır:
* `JFrame`, `JPanel`, `JTabbedPane`, `JMenuBar` (Konteyner ve Düzen)
* `JLabel`, `JButton`, `JTextField`, `JTable` (Girdi ve Çıktı Bileşenleri)
* `Timer` (Oyun Süresi Kontrolü)
* `JOptionPane` (Kullanıcı Uyarı ve Şifre Pencereleri)
