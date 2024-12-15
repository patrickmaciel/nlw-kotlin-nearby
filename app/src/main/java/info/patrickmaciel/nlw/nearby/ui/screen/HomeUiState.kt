package info.patrickmaciel.nlw.nearby.ui.screen

import com.google.android.gms.maps.model.LatLng
import info.patrickmaciel.nlw.nearby.data.model.Category
import info.patrickmaciel.nlw.nearby.data.model.Market

data class HomeUiState(
    val categories: List<Category>? = null,
    val markets: List<Market>? = null,
    val marketLocations: List<LatLng>? = null,
)
