package com.frostsoft.desktopdemo.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.frostsoft.desktopdemo.data.Slot

@Composable
fun RuneLineView(
    slot: Slot,
    isKeystone: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(
                vertical = 8.dp,
                horizontal = 4.dp,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            slot.runes.forEach {
                RuneView(it, isKeystone)
            }
        }
    }

}