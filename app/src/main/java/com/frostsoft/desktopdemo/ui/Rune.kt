package com.frostsoft.desktopdemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.frostsoft.desktopdemo.ui.data.RuneViewData


@Composable
fun Rune(runeData: RuneViewData) {
    Column {
        Image(
            modifier = Modifier
                .size(30.dp)
//                .background(Color.Red)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(runeData.rune.image),
            contentScale = ContentScale.FillBounds,
            contentDescription = ""
        )
//        Text(text = runeData.rune.title)
    }
}
