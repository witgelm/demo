package com.frostsoft.desktopdemo.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.frostsoft.desktopdemo.data.Path
import com.frostsoft.desktopdemo.ui.data.PathViewData

@Composable
fun PathView(
    path: PathViewData,
    onClick: (PathViewData) -> Unit,
) {
    val background = if (path.isSelected) Color.Red else Color.Transparent
    Image(
        modifier = Modifier
            .size(30.dp)
            .background(background)
            .clickable { onClick(path) },
//            .align(Alignment.CenterHorizontally),
        painter = painterResource(path.path.icon),
        contentScale = ContentScale.FillBounds,
        contentDescription = ""
    )
}