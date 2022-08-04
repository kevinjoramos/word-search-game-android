package kevin.jo.ramos.wordsearch.ui

sealed class Screen(val route: String) {
    object GameScreen : Screen("game_screen")
    object SplashScreen : Screen("splash_screen")
}
