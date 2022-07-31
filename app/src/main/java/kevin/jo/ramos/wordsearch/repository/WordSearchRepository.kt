package kevin.jo.ramos.wordsearch.repository;

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordSearchRepository {


    val gameboardGrid: Flow<Array<CharArray>> = flow {
        val gameboard = generateGameboard()
        emit(gameboard)
    }

    private fun generateGameboard(): Array<CharArray> {
        return Array(size = 12, init = {
            CharArray(size = 10, init = { 'A' }
            )
        }
        )
    }
}
