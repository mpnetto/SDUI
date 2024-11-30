package com.sacada.ui.ui.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor() : ViewModel() {
    private val _componentStates = MutableStateFlow<Map<String, Boolean>>(emptyMap())
    val componentStates: StateFlow<Map<String, Boolean>> = _componentStates

    fun updateComponentState(componentId: String, isValid: Boolean) {
        _componentStates.value = _componentStates.value.toMutableMap().apply {
            this[componentId] = isValid
        }
    }

    fun areAllComponentsValid(): Boolean {
        return _componentStates.value.values.all { it }
    }
}