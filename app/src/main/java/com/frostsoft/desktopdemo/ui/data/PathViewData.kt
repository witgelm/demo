package com.frostsoft.desktopdemo.ui.data

import com.frostsoft.desktopdemo.data.Path

data class PathViewData(
    val path: Path,
    val isSelected: Boolean = false,
    val hasKeystoneSlot: Boolean = true,
)