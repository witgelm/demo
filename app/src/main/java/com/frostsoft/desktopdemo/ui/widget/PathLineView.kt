package com.frostsoft.desktopdemo.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frostsoft.desktopdemo.ui.data.PathViewData

@Composable
fun PathLineView(
    paths: List<PathViewData>,
    onClick: (PathViewData) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(
                vertical = 8.dp,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            paths.forEach {
                PathView(it, onClick)
            }
        }
    }
}