# CoffeeShop Uygulaması

CoffeeShop, bir kahve dükkanının menüsünü listelemek, kategori bazlı filtreleme yapmak ve ürünlerin detaylarını görüntülemek için geliştirilmiş bir Android uygulamasıdır. Uygulama, Firebase Realtime Database ile entegre edilmiş ve modern MVVM mimarisi ile yapılandırılmıştır.

## 📚 Kullanılan Teknolojiler ve Kütüphaneler
- **Firebase Realtime Database**
- **Glide**
- **MVVM Mimari**
- **Hilt**

## Özellikler
- **Ürün Listeleme**: RecyclerView kullanılarak ürünler listelenir.
- **Kategori Bazlı Filtreleme**: Kullanıcı, belirli bir kategoriye ait ürünleri görüntüleyebilir.
- **Ürün Detayları**: Ürün detayları, kullanıcı bir ürüne tıkladığında gösterilir.
- **Firebase Entegrasyonu**: Ürün bilgileri Firebase Realtime Database üzerinden alınır.
- **MVVM Mimari**: ViewModel ve Repository ile temiz ve sürdürülebilir bir mimari kullanılmıştır.

---

##  Proje Yapısı

### Adapter
**ListItemAdapter**  
RecyclerView ile ürünleri listelemek için kullanılır.  
- **Glide** kütüphanesi ile ürün resimleri yüklenir.  
- Bir ürüne tıklandığında `DetailActivity`'ye yönlendirme yapılır.

### Model
**ItemsModel**  
Firebase veritabanından alınan ürün verilerini temsil eder.  
- Parcelable yapısıyla, ürün detaylarının bir ekrandan diğerine kolayca taşınması sağlanır.

### Repository
**MainRepository**  
Firebase Realtime Database'den verileri alır.  
- `loadFiltered()` metodu, belirli bir kategoriye ait ürünleri getirir.

### ViewModel
**MainViewModel**  
View ile Repository arasındaki bağlantıyı sağlar.  
- `loadFiltered()` metodu, LiveData kullanarak verileri gözlemlenebilir hale getirir.

---

## 🛠️ Projenin Yapılandırması

### Gradle Build Dosyası
ViewBinding ve DataBinding, UI öğelerini daha kolay yönetmek için etkinleştirilmiştir. Hilt bağımlılık yönetimi entegre edilmiştir.

```kotlin
android {
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.google.firebase:firebase-database:20.0.6")
}
