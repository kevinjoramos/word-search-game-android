package kevin.jo.ramos.wordsearch.repository;

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class WordSearchRepository {


    val gameboardGridFlow: Flow<Array<CharArray>> = flow {
        emit(generateGameboard())
    }

    val wordListFlow: Flow<List<String>> = flow {
        emit(generateWordList())
    }

    private fun generateGameboard(): Array<CharArray> {
        return Array(size = 10, init = {
            CharArray(size = 10, init = { generateRandomChar() }
            )
        }
        )
    }

    private fun generateWordList(): List<String> {
        return listOf("Hello", "World", "Pizza", "Elephant", "Generate", "Fortress")
    }

    private fun generateRandomChar(): Char {
        return Random.nextInt(65, 91).toChar()
    }
}
