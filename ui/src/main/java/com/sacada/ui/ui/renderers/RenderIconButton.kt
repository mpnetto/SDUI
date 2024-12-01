package com.sacada.ui.ui.renderers

import ViewComponent
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sacada.core.model.handleAction
import kotlinx.serialization.json.JsonPrimitive

@Composable
fun RenderIconButton(component: ViewComponent) {
    IconButton(
        onClick = {
            component.action?.let { handleAction(it) }
        }
    ) {
        RenderIcon(component)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRenderIconButton() {
    val testComponent =
        ViewComponent(
            type = "IconButton",
            attributes =
            mapOf(
                "iconName" to JsonPrimitive("home"),
                "contentDescription" to JsonPrimitive("Ajuda")
            )
        )

    RenderIconButton(component = testComponent)
}
