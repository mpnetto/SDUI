package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.sacada.core.model.handleAction
import com.sacada.core.util.getStringAttribute

@Composable
fun RenderButton(component: ViewComponent) {
    val buttonText = remember { component.getStringAttribute("text") }
    val onClick = createOnClickAction(component)

    Button(onClick = onClick) {
        Text(text = buttonText)
    }
}

@Composable
private fun createOnClickAction(component: ViewComponent): () -> Unit = {
    component.action?.let { handleAction(it) }
}