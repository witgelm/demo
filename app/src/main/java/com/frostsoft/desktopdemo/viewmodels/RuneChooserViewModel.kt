package com.frostsoft.desktopdemo.viewmodels

import com.frostsoft.desktopdemo.providers.PathProvider
import com.frostsoft.desktopdemo.ui.data.PathViewData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

class RuneChooserViewModel(
    private val pathProvider: PathProvider,
) {

    private val immutablePath = pathProvider.getPath().map { path -> PathViewData(path) }

    private val _paths = MutableStateFlow(immutablePath)
    private val _secondPath = MutableStateFlow(
        immutablePath.map { pathData ->
            pathData.copy(
                path = pathData.path.copy(
                    slots = pathData.path.slots.subList(1, pathData.path.slots.size)
                ),
                hasKeystoneSlot = false
            )
        }
    )

    val paths: StateFlow<List<PathViewData>> = _paths.asStateFlow()
    val secondPath: StateFlow<List<PathViewData>> =
        _secondPath.combine(_paths) { second, first ->
            val firstSelectedId = first.firstOrNull { it.isSelected }?.path?.id ?: -1
            second.filter { it.path.id != firstSelectedId }
        }.stateIn(
            scope = CoroutineScope(Job()),
            started = SharingStarted.Eagerly,
            initialValue = _secondPath.value
        )

    fun selectMainPath(selectedPath: PathViewData) {
        if (selectedPath.isSelected) return
        _paths.update { paths ->
            paths.map { pathView ->
                pathView.copy(
                    isSelected = selectedPath.path.id == pathView.path.id
                )
            }
        }
    }

    fun selectSecondPath(selectedPath: PathViewData) {
        if (selectedPath.isSelected) return
        _secondPath.update { paths ->
            paths.map { pathView ->
                pathView.copy(
                    isSelected = selectedPath.path.id == pathView.path.id
                )
            }
        }
    }
}