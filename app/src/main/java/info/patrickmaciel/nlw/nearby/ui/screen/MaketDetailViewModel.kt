package info.patrickmaciel.nlw.nearby.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.patrickmaciel.nlw.nearby.core.network.NearbyRemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MaketDetailViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MarketDetailUiState())
    val uiState: StateFlow<MarketDetailUiState> = _uiState.asStateFlow()

    fun onEvent(event: MarketDetailUiEvent) {
        when(event) {
            is MarketDetailUiEvent.OnFetchCoupon -> fetchCoupon(qrCodeContent = event.qrCodeContent)
            is MarketDetailUiEvent.OnFetchRules -> fetchRules(marketId = event.marketId)
            MarketDetailUiEvent.OnResetCoupon -> resetCoupon()
        }
    }

    private fun fetchCoupon(qrCodeContent: String) {
        viewModelScope.launch {
            NearbyRemoteDataSource.patchCupom(marketId = qrCodeContent).fold(
                onSuccess = { coupon ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(coupon = coupon.coupon)
                    }
                },
                onFailure = { _ ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(coupon = "")
                    }
                }
            )
        }
    }

    private fun fetchRules(marketId: String) {
        viewModelScope.launch {
            NearbyRemoteDataSource.getMarketsDetails(marketId = marketId).fold(
                onSuccess = { marketDetails ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(rules = marketDetails.rules)
                    }
                },
                onFailure = { _ ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(rules = emptyList())
                    }
                }
            )
        }
    }


    private fun resetCoupon() {
        _uiState.update { currentUiState ->
            currentUiState.copy(
                coupon = null
            )
        }
    }
}