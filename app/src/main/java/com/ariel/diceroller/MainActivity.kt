package com.ariel.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariel.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
      //  .background(MaterialTheme.colorScheme.onBackground)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var resultTop by rememberSaveable { mutableStateOf(1) }
    var resultBottom by rememberSaveable { mutableStateOf(3) }
    val imageResourceTop = when(resultTop) {
        1 -> R.drawable.dice_dark_1
        2 -> R.drawable.dice_dark_2
        3 -> R.drawable.dice_dark_3
        4 -> R.drawable.dice_dark_4
        5 -> R.drawable.dice_dark_5
        else -> R.drawable.dice_dark_6
    }
    val imageResourceBottom = when(resultBottom) {
        1 -> R.drawable.dice_pur_1
        2 -> R.drawable.dice_pur_2
        3 -> R.drawable.dice_pur_3
        4 -> R.drawable.dice_pur_4
        5 -> R.drawable.dice_pur_5
        else -> R.drawable.dice_pur_6
    }

    Column (
        modifier = modifier
            .clickable( onClick = {
                resultTop = (1..6).random()
                resultBottom = (1..6).random()
            })
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Bottom
    ) {

    Image(
        painter = painterResource(imageResourceTop),
        contentDescription = resultTop.toString(),
        modifier = Modifier
            .padding(16.dp)
            .width(128.dp)
            .align(alignment = Alignment.Start)
            .weight(1f)
    )

    Image(
        painter = painterResource(imageResourceBottom),
        contentDescription = resultBottom.toString(),
        modifier = Modifier
            .padding(16.dp)
            .width(128.dp)
            .align(alignment = Alignment.End)
            .weight(1f)
    )

        Row(){
            Text(
                text = resultTop.toString(),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = resultBottom.toString(),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(16.dp)
            )

        }
    }

}
