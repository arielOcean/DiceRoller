package com.ariel.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var resultTop by rememberSaveable { mutableStateOf(2) }
    var resultBottom by rememberSaveable { mutableStateOf(3) }
    val imageResourceTop = when (resultTop) {
        1 -> R.drawable.dice_dark_1
        2 -> R.drawable.dice_dark_2
        3 -> R.drawable.dice_dark_3
        4 -> R.drawable.dice_dark_4
        5 -> R.drawable.dice_dark_5
        else -> R.drawable.dice_dark_6
    }
    val imageResourceBottom = when (resultBottom) {
        1 -> R.drawable.dice_pur_1
        2 -> R.drawable.dice_pur_2
        3 -> R.drawable.dice_pur_3
        4 -> R.drawable.dice_pur_4
        5 -> R.drawable.dice_pur_5
        else -> R.drawable.dice_pur_6
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
        ){

    Column(
        modifier = modifier
            .clickable(onClick = {
                resultTop = (1..6).random()
                resultBottom = (1..6).random()
            }),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        Row() {

            TextWithNumbers(
                resultTop.toString(),
                MaterialTheme.colorScheme.onErrorContainer
            )

            TextWithNumbers(
                resultBottom.toString(),
                MaterialTheme.colorScheme.onTertiaryContainer
            )

        }

        ImageDice(
            imageResourceTop,
            resultTop.toString(),
            Modifier
                .padding(16.dp)
                .width(128.dp)
                .align(alignment = Alignment.Start)
                .weight(1f) )


        ImageDice(
            imageResourceBottom,
            resultBottom.toString(),
            Modifier
            .padding(16.dp)
            .width(128.dp)
            .align(alignment = Alignment.End)
            .weight(1f) )
    }

        if (resultTop == resultBottom)
            Banner(id = R.string.banner_id_demo)


    }

}

@Composable
fun ImageDice(
    imageResource: Int,
    content: String,
    modifier: Modifier
){
    Image(
        painter = painterResource(imageResource),
        contentDescription = content,
        modifier = modifier
    )

}
@Composable
fun TextWithNumbers(
    textNumber: String,
    color: Color
){
    Text(
        text = textNumber,
        color =color,
        fontSize=42.sp,
        fontFamily= FontFamily.Cursive,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Preview
@Composable
fun DiceRollerAppPreview() {

    DiceRollerTheme {
        DiceRollerApp()
    }
}

