package kevin.jo.ramos.wordsearch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import kevin.jo.ramos.wordsearch.Navigation
import kevin.jo.ramos.wordsearch.viewmodel.WordSearchViewModel

class MainActivity : ComponentActivity() {

    val viewModel: WordSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}