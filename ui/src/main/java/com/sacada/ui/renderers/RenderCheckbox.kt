package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.sacada.core.util.getStringAttribute

@Composable
fun RenderCheckbox(component: ViewComponent) {
    val isChecked = rememberSaveable { mutableStateOf(false) }
    val labelText = component.getStringAttribute("label")

    Row {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it }
        )
        Text(text = labelText)
    }
}