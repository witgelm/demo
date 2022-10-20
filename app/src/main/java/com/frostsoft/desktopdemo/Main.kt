package com.frostsoft.desktopdemo

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.frostsoft.desktopdemo.providers.PathProviderImpl
import com.frostsoft.desktopdemo.ui.widget.KeyRuneSectore
import com.frostsoft.desktopdemo.viewmodels.RuneChooserViewModel

@Composable
@Preview
fun App() {
    val viewModel = remember {
        RuneChooserViewModel(
            pathProvider = PathProviderImpl(useResource("runesReforged.json") { stream ->
                stream.bufferedReader().use { it.readText() }
            })
        )
    }
    val paths by viewModel.paths.collectAsState()
    val secnd by viewModel.secondPath.collectAsState(emptyList())
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff020C13))
        ) {
            KeyRuneSectore(paths, viewModel::selectMainPath)
            KeyRuneSectore(secnd, viewModel::selectSecondPath)
        }
    }
}

fun main() = application {
    Window(

        onCloseRequest = ::exitApplication,
        title = "Stat",
        resizable = false,
//        undecorated = true,
        state = rememberWindowState(
            size = DpSize(188.dp, 720.dp)
        )
    ) {
        App()
    }
}
