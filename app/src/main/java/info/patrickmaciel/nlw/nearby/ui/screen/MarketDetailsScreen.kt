package info.patrickmaciel.nlw.nearby.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import info.patrickmaciel.nlw.nearby.R
import info.patrickmaciel.nlw.nearby.data.model.Market
import info.patrickmaciel.nlw.nearby.data.model.mock.mockMarkets
import info.patrickmaciel.nlw.nearby.ui.component.button.NearbyButton
import info.patrickmaciel.nlw.nearby.ui.component.marketDetails.NearbyMarketDetailsCoupons
import info.patrickmaciel.nlw.nearby.ui.component.marketDetails.NearbyMarketDetailsInfos
import info.patrickmaciel.nlw.nearby.ui.component.marketDetails.NearbyMarketDetailsRules
import info.patrickmaciel.nlw.nearby.ui.theme.Typography

@Composable
fun MarketDetailsScreen(
    modifier: Modifier = Modifier,
    market: Market,
    onNavigationBack: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // TODO: enable when the API is ready
//        AsyncImage(
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            contentDescription = "Imagem do Local",
            contentScale = ContentScale.Crop,
//            model = market.cover
            painter = painterResource(id = R.drawable.img_burger)
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight()
                    .padding(36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = market.name,
                        style = Typography.headlineLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = market.description,
                        style = Typography.bodyLarge
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))
                
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    NearbyMarketDetailsInfos(
                        market = market
                    )

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )

//                    if (market.rules.isNotEmpty()) {
//                        NearbyMarketDetailsRules(
//                            rules = market.rules
//                        )
//                        HorizontalDivider(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 24.dp)
//                        )
//                    }

                    NearbyMarketDetailsCoupons(
                        coupons = listOf(
                            "10% de desconto",
                            "20% de desconto",
                            "30% de desconto"
                        )
                    )
                }

                NearbyButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Ler QR Code",
                    onClick = {}
                )
            }
        }

        NearbyButton(
            modifier = Modifier.align(Alignment.TopStart).padding(24.dp),
            iconRes = R.drawable.ic_arrow_left,
            onClick = onNavigationBack
        )
    }
}

@Preview
@Composable
private fun MarketDetailsScreenPreview() {
    MarketDetailsScreen(
        market = mockMarkets.first(),
        onNavigationBack = {}
    )
}