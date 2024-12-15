package info.patrickmaciel.nlw.nearby.ui.screen

import info.patrickmaciel.nlw.nearby.data.model.Rule

data class MarketDetailUiState(
    val rules: List<Rule>? = null,
    val coupon: String? = null
)
