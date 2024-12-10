package info.patrickmaciel.nlw.nearby.ui.component.market

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.patrickmaciel.nlw.nearby.R
import info.patrickmaciel.nlw.nearby.data.model.Market
import info.patrickmaciel.nlw.nearby.ui.theme.Gray100
import info.patrickmaciel.nlw.nearby.ui.theme.Gray200
import info.patrickmaciel.nlw.nearby.ui.theme.Gray400
import info.patrickmaciel.nlw.nearby.ui.theme.Gray500
import info.patrickmaciel.nlw.nearby.ui.theme.RedBase
import info.patrickmaciel.nlw.nearby.ui.theme.Typography

@Composable
fun NearbyMarketCard(
    modifier: Modifier = Modifier,
    market: Market,
    onClick: (Market) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(width = 1.dp, color = Gray200, shape = RoundedCornerShape(12.dp)),
        onClick = { onClick(market) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth(0.3f)
                    .height(IntrinsicSize.Min)
                    .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.img_burger), // TODO: change to market.cover
                contentDescription = "Imagem do Estabelecimento"
            )

            Column {
                Text(
                    text = market.name,
                    style = Typography.headlineSmall.copy(fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = market.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Gray500,
                    style = Typography.bodyLarge.copy(fontSize = 12.sp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        tint = if (market.coupons > 0) RedBase else Gray400,
                        painter = painterResource(id = R.drawable.ic_ticket),
                        contentDescription = "Ícone de Cupom"
                    )
                    Text(
                        text = "${market.coupons} cupons disponíveis",
                        color = Gray400,
                        style = Typography.bodyMedium.copy(fontSize = 12.sp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NearbyMarketCardPreview() {
    NearbyMarketCard(
        modifier = Modifier.fillMaxWidth(),
        market = Market(
            id = "1",
            categoryId = "1",
            name = "Supermercado do Zé",
            description = "O supermercado mais próximo de você! Venha conferir nossas ofertas! Aqui você encontra tudo o que precisa para sua casa.",
            coupons = 10,
            rules = emptyList(),
            latitude = -23.550520,
            longitude = -46.633308,
            address = "Rua das Flores, 123",
            phone = "(11) 99999-9999",
            cover = "https://images.unsplash.com/photo-1612838320302-3b3b3f1b3b3b"
        )
    ) { }

}

@Preview
@Composable
private fun NearbyMarketCardNoCouponsPreview() {
    NearbyMarketCard(
        modifier = Modifier.fillMaxWidth(),
        market = Market(
            id = "2",
            categoryId = "2",
            name = "Jantinha da Tia Lurdes",
            description = "A melhor jantinha da região! Venha experimentar.",
            coupons = 0,
            rules = emptyList(),
            latitude = -23.550520,
            longitude = -46.633308,
            address = "Rua das Flores, 123",
            phone = "(11) 99999-9999",
            cover = "https://images.unsplash.com/photo-1612838320302-3b3b3f1b3b3b"
        )
    ) { }

}