package kevin.jo.ramos.wordsearch

sealed class Screen(val route: String) {
    object GameScreen : Screen("game_screen")
}
