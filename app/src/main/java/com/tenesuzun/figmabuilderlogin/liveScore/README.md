# LiveScore Package

Bu paket, Figma tasarımından oluşturulan canlı skor ve fikstür gösterim ekranını içerir.

## 📁 Dosya Yapısı

```
liveScore/
├── LiveScoreColors.kt              # Renk tanımlamaları
├── LiveScoreModels.kt              # Veri modelleri (Match, Team, Standing, vb.)
├── LiveScoreScreen.kt              # Basit ekran (ViewModel olmadan)
├── LiveScoreScreenWithViewModel.kt # Production ekranı (ViewModel ile)
├── LiveScoreViewModel.kt           # ViewModel ve UI State
├── StandingsTable.kt               # Puan durumu tablosu bileşeni
└── README.md                       # Bu dosya
```

## 🎨 Tasarım Sistemi

### Renkler
- **Spor Yeşili**: `#489941` - Spor kategorisi için ana renk
- **Ekonomi Mavisi**: `#2951DD` - Linkler ve ekonomi kategorisi için
- **Koyu Gri**: `#4A5169` - Metin rengi
- **Beyaz**: `#FFFFFF` - Arka plan
- **Açık Yeşil**: `rgba(72, 153, 65, 0.1)` - Arka plan vurguları için

### Bileşenler

#### 1. SportsFixtureCard
Ana kart bileşeni. İki sekme içerir:
- **PUAN DURUMU**: Lig puan tablosu
- **FİKSTÜR**: Maç fikstürü

#### 2. CustomTabRow
Özel sekme satırı:
- Yuvarlatılmış üst köşeler
- Aktif/pasif durum gösterimi
- Yeşil renk teması

#### 3. DropdownChip
Açılır menü bileşeni:
- Lig seçimi
- Hafta seçimi

#### 4. MatchRow
Maç satırı gösterimi:
- Ev sahibi takım
- Deplasman takımı
- Skor
- Takım logoları (placeholder)

#### 5. StandingsTable
Puan durumu tablosu:
- Sıralama, takım adı, oynanan, galibiyet, beraberlik, mağlubiyet, averaj, puan

## 🔧 Kullanım

### Basit Versiyon (ViewModel olmadan)

```kotlin
@Composable
fun MyScreen() {
    LiveScoreScreen()
}
```

### Production Versiyonu (ViewModel ile)

```kotlin
@Composable
fun MyScreen() {
    val viewModel: LiveScoreViewModel = viewModel()
    LiveScoreScreenWithViewModel(viewModel)
}
```

## 📊 Veri Modelleri

### Match
```kotlin
data class Match(
    val id: Int,
    val homeTeam: Team,
    val awayTeam: Team,
    val score: String,
    val date: String,
    val time: String = ""
)
```

### Team
```kotlin
data class Team(
    val name: String,
    val logoUrl: String = ""
)
```

### Standing
```kotlin
data class Standing(
    val position: Int,
    val team: Team,
    val played: Int,
    val won: Int,
    val drawn: Int,
    val lost: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int,
    val points: Int
)
```

## 🎯 ViewModel State Yönetimi

### LiveScoreUiState
```kotlin
data class LiveScoreUiState(
    val selectedTab: Int = 1,              // 0: Standings, 1: Fixtures
    val selectedLeague: String,             // Seçili lig
    val selectedWeek: String,               // Seçili hafta
    val matches: List<Match>,               // Maçlar listesi
    val standings: List<Standing>,          // Puan durumu
    val isLoading: Boolean = false,         // Yükleme durumu
    val error: String? = null               // Hata mesajı
)
```

### ViewModel Metodları
- `selectTab(tabIndex: Int)` - Sekme değiştir
- `selectLeague(league: String)` - Lig seç
- `selectWeek(week: String)` - Hafta seç
- `refreshData()` - Verileri yenile

## 🚀 Geliştirme Notları

### MainActivity'de Kullanım
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FigmaBuilderLoginTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LiveScoreScreenWithViewModel()
                }
            }
        }
    }
}
```

### Mock Data
`MockData` objesi test verileri içerir:
- `sampleTeams` - Örnek takımlar
- `sampleMatches` - Örnek maçlar
- `sampleStandings` - Örnek puan durumu

## 📝 TODO / Gelecek Geliştirmeler

- [ ] Gerçek API entegrasyonu
- [ ] Takım logoları için image loading (Coil/Glide)
- [ ] Dropdown menü açılma fonksiyonelliği
- [ ] Maç detay ekranı navigasyonu
- [ ] Pull-to-refresh özelliği
- [ ] Offline cache desteği
- [ ] Canlı skor güncellemeleri (WebSocket/Firebase)
- [ ] Favori takım seçimi
- [ ] Bildirim desteği
- [ ] Dark mode desteği

## 🎨 Figma Tasarımı

Tasarım, Figma'dan export edilmiş ve Jetpack Compose ile birebir uygulanmıştır:
- Tüm renkler CSS değişkenlerinden alınmıştır
- Spacing değerleri piksel-perfect korunmuştur
- Font aileleri ve ağırlıkları (SF Pro Display) belirtilmiştir
- Border radius, shadow ve opacity değerleri aynıdır

## 📱 Önizleme

Preview composable'ları test için mevcuttur:
```kotlin
@Preview
@Composable
fun LiveScoreScreenPreview() {
    LiveScoreScreen()
}
```

## 🔗 İlgili Dosyalar

- `MainActivity.kt` - Ana activity
- `ui/theme/Color.kt` - Tema renkleri
- `ui/theme/Type.kt` - Tipografi
- `ui/theme/Theme.kt` - Ana tema
