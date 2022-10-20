package com.frostsoft.desktopdemo.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.frostsoft.desktopdemo.data.Rune

@Composable
fun RuneView(rune: Rune, isBig: Boolean) {
    val size = if (isBig) 40.dp else 24.dp
    Image(
        modifier = Modifier
            .size(size),
//                .background(Color.Red)
//            .align(Alignment.CenterHorizontally),
        painter = painterResource(rune.image),
        contentScale = ContentScale.FillBounds,
        contentDescription = ""
    )
}