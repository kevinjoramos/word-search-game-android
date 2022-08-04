package kevin.jo.ramos.wordsearch

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kevin.jo.ramos.wordsearch.ui.Screen
import kevin.jo.ramos.wordsearch.ui.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.GameScreen.route) {
        composable(Screen.GameScreen.route) { GameScreen() }
        composable(Screen.SplashScreen.route) { SplashScreen() }
    }
}
