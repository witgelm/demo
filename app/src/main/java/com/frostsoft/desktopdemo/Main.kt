package com.frostsoft.desktopdemo

import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.unit.Dp
import com.frostsoft.desktopdemo.ui.ColorBox
import com.frostsoft.desktopdemo.ui.KeyStone

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    MaterialTheme {
        val itemsText = listOf(
                MaterialTheme.typography.h1,
                MaterialTheme.typography.h2,
                MaterialTheme.typography.h3,
                MaterialTheme.typography.h4,
                MaterialTheme.typography.h5,
                MaterialTheme.typography.h6,
                MaterialTheme.typography.subtitle1,
                MaterialTheme.typography.subtitle2,
                MaterialTheme.typography.body1,
                MaterialTheme.typography.body2,
                MaterialTheme.typography.button,
                MaterialTheme.typography.caption,
                MaterialTheme.typography.overline,
        )
        val colors = listOf(
                MaterialTheme.colors.primary,
                MaterialTheme.colors.onPrimary,
                MaterialTheme.colors.primaryVariant,

                MaterialTheme.colors.secondary,
                MaterialTheme.colors.onSecondary,
                MaterialTheme.colors.secondaryVariant,

                )
        LazyColumn {
            item {
                KeyStone()
            }
            items(itemsText) {
                Text(
                        text = text,
                        style = it,
                )
            }
            items(colors) {
                ColorBox(it)
            }
        }
    }
}

fun main() = application {
    Window(
            onCloseRequest = ::exitApplication,
            title = "Stat",
            resizable = false,
            state = rememberWindowState(
                    size = DpSize(Dp(360f), Dp(720f))
            )
    ) {
        App()
    }
    Window(
            onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}
