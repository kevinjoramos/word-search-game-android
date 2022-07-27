package kevin.jo.ramos.wordsearch

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun GameScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Timer()
        WordBank()
        GameGrid()
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
fun GameGrid() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        repeat(12) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(10) {
                    Column() {
                        Text("A")
                    }
                }
            }
        }
    }
}
