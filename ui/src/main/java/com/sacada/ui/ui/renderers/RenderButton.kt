package com.sacada.ui.ui.renderers

import ViewComponent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.sacada.core.model.handleAction
import com.sacada.core.util.getStringAttribute
import kotlinx.serialization.json.JsonPrimitive

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

@Preview(showBackground = true)
@Composable
fun PreviewRenderButton() {
    val sampleComponent =
        ViewComponent(
            type = "Button",
            attributes =
            mapOf(
                "text" to JsonPrimitive("Click Me")
            )
        )
    RenderButton(component = sampleComponent)
}
