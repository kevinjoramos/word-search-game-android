package kevin.jo.ramos.wordsearch

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kevin.jo.ramos.wordsearch.viewmodel.WordSearchViewModel

@Preview
@Composable
fun GameScreen(viewModel: WordSearchViewModel = viewModel()) {

    val gameboardGrid =
        viewModel.gameboardGrid.collectAsState(initial = Array(10) { CharArray(10) })

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Timer()
        WordBank()
        GameGrid(gameboardGrid = gameboardGrid)
    }
}

@Composable
fun Timer() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(text = "0:00")
    }
}

@Composable
fun WordBank() {
    repeat(2) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 108.dp)
            ) {
                repeat(3) {
                    Column {
                        Text(text = "Word")
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
        for (row in gameboardGrid.value) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (charItem in row) {
                    Column(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .width(5.dp)
                    ) {
                        Text(
                            text = charItem.toString(),
                            style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center)
                        )
                    }
                }
            }
        }
    }
}
