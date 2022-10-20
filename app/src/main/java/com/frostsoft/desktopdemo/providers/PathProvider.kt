package com.frostsoft.desktopdemo.providers

import com.frostsoft.desktopdemo.data.Path

interface PathProvider {
    fun getPath(): List<Path>
}