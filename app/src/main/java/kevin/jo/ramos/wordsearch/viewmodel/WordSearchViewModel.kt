package kevin.jo.ramos.wordsearch.viewmodel

import androidx.lifecycle.ViewModel
import kevin.jo.ramos.wordsearch.repository.WordSearchRepository

class WordSearchViewModel : ViewModel() {
    private val repository = WordSearchRepository()

    val gameboardGrid = repository.gameboardGrid

}