package kevin.jo.ramos.wordsearch

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kevin.jo.ramos.wordsearch.viewmodel.WordSearchViewModel

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GameScreen(viewModel: WordSearchViewModel = viewModel()) {

    val gameboardGrid =
        viewModel.gameboardGridFlow.collectAsState(initial = Array(10) { CharArray(10) })
    val wordList = viewModel.wordListFlow.collectAsState(initial = listOf())
    val timeLeft = viewModel.timerFlow.collectAsState(initial = 150)

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Timer(timeLeft = timeLeft)
        WordBank(wordList = wordList)
        Spacer(modifier = Modifier.weight(1f))
        GameGrid(gameboardGrid = gameboardGrid)
    }
}

@Composable
fun Timer(timeLeft: State<Int>) {
    val minutesString: String = timeLeft.value.floorDiv(60).toString()
    val seconds: Int = timeLeft.value.mod(60)
    val secondsString = if (seconds > 9) seconds.toString() else "0$seconds"

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = "$minutesString:$secondsString", style = TextStyle(fontSize = 16.sp))
    }
}

@Composable
fun WordBank(wordList: State<List<String>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Card(
            elevation = 3.dp,
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
            ) {
                wordList.value.chunked(3).map { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        row.map { word ->
                            Column() {
                                Text(text = word)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GameGrid(gameboardGrid: State<Array<CharArray>>) {
    Column(
        modifier = Modifier
            .padding(24.dp)
    ) {
        gameboardGrid.value.map { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                row.map { letter ->
                    Column(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .width(5.dp)
                    ) {
                        Text(
                            text = letter.toString(),
                            style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center)
                        )
                    }
                }
            }
        }
    }
}
