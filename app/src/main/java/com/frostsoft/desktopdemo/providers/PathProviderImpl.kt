package com.frostsoft.desktopdemo.providers

import com.frostsoft.desktopdemo.data.Path
import com.frostsoft.desktopdemo.data.Rune
import com.frostsoft.desktopdemo.data.Slot
import org.json.JSONArray
import org.json.JSONObject

class PathProviderImpl(json: String) : PathProvider {

    private val paths = JSONArray(json).map {
        it as JSONObject
        val slots = it.getJSONArray("slots").map { runeSlot ->
            runeSlot as JSONObject
            runeSlot.getJSONArray("runes")
        }.map { slot ->
            val runes = slot.map { rune ->
                rune as JSONObject
                Rune(
                    image = rune.getString("icon"),
                    title = rune.getString("name"),
                    description = rune.getString("shortDesc"),
                )
            }
            Slot(runes)
        }
        Path(
            id = it.getInt("id"),
            key = it.getString("key"),
            icon = it.getString("icon"),
            name = it.getString("name"),
            slots = slots
        )
    }

    override fun getPath(): List<Path> = paths.sortedBy { it.id }
}