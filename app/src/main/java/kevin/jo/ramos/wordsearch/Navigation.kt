package kevin.jo.ramos.wordsearch

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.GameScreen.route) {
        composable(Screen.GameScreen.route) { GameScreen() }
    }
}
