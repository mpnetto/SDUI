package com.sacada.ui.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class ScreenViewModel
@Inject
constructor() : ViewModel() {
    private val _componentStates = MutableStateFlow<Map<String, Boolean>>(emptyMap())
    val componentStates: StateFlow<Map<String, Boolean>> = _componentStates

    fun updateComponentState(componentId: String, isValid: Boolean) {
        _componentStates.value =
            _componentStates.value.toMutableMap().apply {
                this[componentId] = isValid
            }
    }

    val areAllComponentsValid: StateFlow<Boolean> =
        _componentStates
            .map { states -> states.values.all { it } }
            .stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                true
            )
}
