package com.frostsoft.desktopdemo.data

data class Path(
    val id: Int,
    val key: String,
    val icon: String,
    val name: String,
    val slots: List<Slot>
)