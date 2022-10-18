package com.frostsoft.desktopdemo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue


@Composable
fun ColorBox(color: Color) {
    Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(color),
    ) {
        Text(text = "#" + color.toArgb().absoluteValue.toString(16))
    }
}