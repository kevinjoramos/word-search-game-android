package kevin.jo.ramos.wordsearch.repository;

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class WordSearchRepository {


    val gameboardGrid: Flow<Array<CharArray>> = flow {
        val gameboard = generateGameboard()
        emit(gameboard)
    }

    private fun generateGameboard(): Array<CharArray> {
        return Array(size = 10, init = {
            CharArray(size = 10, init = { generateRandomChar() }
            )
        }
        )
    }

    private fun generateRandomChar(): Char {
        return Random.nextInt(65, 91).toChar()
    }
}
