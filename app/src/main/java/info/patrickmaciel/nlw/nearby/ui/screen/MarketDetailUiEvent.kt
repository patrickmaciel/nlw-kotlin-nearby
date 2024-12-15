package info.patrickmaciel.nlw.nearby.ui.screen

sealed class MarketDetailUiEvent {
    data class OnFetchRules(val marketId: String): MarketDetailUiEvent()
    data class OnFetchCoupon(val qrCodeContent: String): MarketDetailUiEvent()
    data object OnResetCoupon: MarketDetailUiEvent()
}