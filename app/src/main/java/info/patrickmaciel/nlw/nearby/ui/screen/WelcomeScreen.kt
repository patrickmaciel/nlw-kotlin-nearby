package info.patrickmaciel.nlw.nearby.ui.screen

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import info.patrickmaciel.nlw.nearby.R
import info.patrickmaciel.nlw.nearby.ui.component.button.NearbyButton
import info.patrickmaciel.nlw.nearby.ui.theme.Gray500
import info.patrickmaciel.nlw.nearby.ui.theme.RedBase
import info.patrickmaciel.nlw.nearby.ui.theme.Typography

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 48.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        WelcomeHeader()

        WelcomeContent()

        NearbyButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Começar",
            onClick = {}
        )
    }
}

@Composable
fun WelcomeContent(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Veja como funciona",
            style = Typography.headlineLarge
        )
        WelcomeHowItWorksTip(
            modifier = modifier.fillMaxWidth(),
            title = "Encontre estabelecimentos",
            subtitle = "Veja locais perto de você que são parceiros Nearby",
            iconRes = R.drawable.ic_map_pin
        )
        WelcomeHowItWorksTip(
            modifier = modifier.fillMaxWidth(),
            title = "Ative o cupom com QR Code",
            subtitle = "Escanei o código no establecimento para usar o beneficio",
            iconRes = R.drawable.ic_qrcode
        )
        WelcomeHowItWorksTip(
            modifier = modifier.fillMaxWidth(),
            title = "Garanta vantagens perto de você",
            subtitle = "Ative cupons onde estiver, em diferentes tipos de estabelecimentos",
            iconRes = R.drawable.ic_ticket
        )
    }
}

@Composable
fun WelcomeHowItWorksTip(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    @DrawableRes iconRes: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = iconRes),
            tint = RedBase,
            contentDescription = "Ícone Como Funciona"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = Typography.headlineSmall
            )
            Text(
                text = subtitle,
                style = Typography.bodyLarge,
                color = Gray500
            )
        }
    }
}

@Composable
fun WelcomeHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo_logo_icon),
            contentDescription = "Nearby Imagem Logo",
        )
        Spacer(modifier = modifier.heightIn(24.dp))
        Text(
            text = "Boas vindas ao Nearby",
            style = Typography.headlineLarge
        )
        Text(
            text = "Tenha cupons de vantagens para usar em seus estabelecimentos favoritos",
            style = Typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}