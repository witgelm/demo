package com.frostsoft.desktopdemo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text


@Composable
fun KeyStone() {
    Column {
        Box(
                modifier = Modifier
                        .size(30.dp)
                        .background(Color.Red)
                        .align(Alignment.CenterHorizontally)
        )
        Text(text = "KeyStone")
    }
}
