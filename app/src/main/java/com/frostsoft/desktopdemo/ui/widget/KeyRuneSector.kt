package com.frostsoft.desktopdemo.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.frostsoft.desktopdemo.ui.data.PathViewData

@Composable
fun KeyRuneSectore(
    paths: List<PathViewData>,
    onPathClick: (PathViewData) -> Unit,
) {
    Row(
        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xff020C13))
            .requiredHeight(250.dp)
    ) {
        PathLineView(paths, onPathClick)
        paths.firstOrNull { it.isSelected }?.let { pathViewData ->
            pathViewData.path
                .slots
                .forEachIndexed { index, slots ->
                    RuneLineView(slots, index == 0 && pathViewData.hasKeystoneSlot)
                }
        }

    }
}