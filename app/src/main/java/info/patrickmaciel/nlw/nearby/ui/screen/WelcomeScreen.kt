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
import info.patrickmaciel.nlw.nearby.ui.component.welcome.WelcomeContent
import info.patrickmaciel.nlw.nearby.ui.component.welcome.WelcomeHeader
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

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}