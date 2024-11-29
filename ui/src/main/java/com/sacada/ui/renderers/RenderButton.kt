package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun RenderButton(component: ViewComponent) {
    val text = component.attributes["text"]?.jsonPrimitive?.content ?: "Button"

    Button(
        onClick = {
            component.action?.let {  }
        },
    ) {
        Text(text)
    }
}