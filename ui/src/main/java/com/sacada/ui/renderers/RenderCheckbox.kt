package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun RenderCheckbox(component: ViewComponent) {
    val isChecked = remember { mutableStateOf(false) }
    Row {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it }
        )
        Text(text = component.attributes["label"]?.jsonPrimitive?.content ?: "Checkbox")
    }
}