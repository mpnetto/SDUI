package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.sacada.core.util.getStringAttribute

@Composable
fun RenderButton(component: ViewComponent) {
    val text = component.getStringAttribute("text")

    Button(
        onClick = {
            component.action?.let {  }
        },
    ) {
        Text(text)
    }
}