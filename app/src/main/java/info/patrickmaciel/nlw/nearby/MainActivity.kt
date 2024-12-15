package info.patrickmaciel.nlw.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import info.patrickmaciel.nlw.nearby.data.model.Market
import info.patrickmaciel.nlw.nearby.ui.screen.HomeScreen
import info.patrickmaciel.nlw.nearby.ui.screen.MarketDetailsScreen
import info.patrickmaciel.nlw.nearby.ui.screen.SplashScreen
import info.patrickmaciel.nlw.nearby.ui.screen.WelcomeScreen
import info.patrickmaciel.nlw.nearby.ui.screen.route.Home
import info.patrickmaciel.nlw.nearby.ui.screen.route.Splash
import info.patrickmaciel.nlw.nearby.ui.screen.route.Welcome
import info.patrickmaciel.nlw.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash,
                ) {
                    composable<Splash> {
                        SplashScreen(
                            modifier = Modifier.fillMaxSize(),
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }

                    composable<Welcome> {
                        WelcomeScreen(
                            onNavigateToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }

                    composable<Home> {
                        HomeScreen(
                            onNavigateToMarketDetails = { selectedMarket ->
                                navController.navigate(selectedMarket)
                            }
                        )
                    }

                    composable<Market> {
                        val selectedMarket = it.toRoute<Market>()
                        MarketDetailsScreen(
                            market = selectedMarket,
                            onNavigationBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}