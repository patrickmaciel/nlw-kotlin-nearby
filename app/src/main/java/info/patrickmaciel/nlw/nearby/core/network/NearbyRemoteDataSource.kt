package info.patrickmaciel.nlw.nearby.core.network

import info.patrickmaciel.nlw.nearby.core.network.KtorHttpClient.httpClientAndroid
import info.patrickmaciel.nlw.nearby.data.model.Category
import info.patrickmaciel.nlw.nearby.data.model.Coupon
import info.patrickmaciel.nlw.nearby.data.model.Market
import info.patrickmaciel.nlw.nearby.data.model.MarketDetails
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {
    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"

    private const val BASE_URL = LOCAL_HOST_EMULATOR_BASE_URL

    // 1 - busca categorias
    // 2 - busca de locais com base em uma categoria
    // 3 - busca de detalhes de um local
    // 4 - gerar cupom a partir da leitura do qrcode

    suspend fun getCategories(): Result<List<Category>> = try {
        val categories = httpClientAndroid.get("$BASE_URL/categories").body<List<Category>>()
        Result.success(categories)
    } catch (e: Exception) {
        Result.failure(e);
    }

    suspend fun getMarkets(categoryId: String): Result<List<Market>> = try {
        val markets = httpClientAndroid.get("$BASE_URL/markets/category/${categoryId}").body<List<Market>>()
        Result.success(markets)
    } catch (e: Exception) {
        Result.failure(e);
    }

    suspend fun getMarketsDetails(marketId: String): Result<MarketDetails> = try {
        val market = httpClientAndroid.get("$BASE_URL/markets/${marketId}").body<MarketDetails>()
        Result.success(market)
    } catch (e: Exception) {
        Result.failure(e);
    }

    suspend fun patchCupom(marketId: String): Result<Coupon> = try {
        val coupon = httpClientAndroid.patch("$BASE_URL/coupons/${marketId}").body<Coupon>()
        Result.success(coupon)
    } catch (e: Exception) {
        Result.failure(e);
    }
}