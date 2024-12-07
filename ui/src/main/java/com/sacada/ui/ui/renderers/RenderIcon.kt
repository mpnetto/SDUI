package com.sacada.ui.ui.renderers

import ViewComponent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sacada.core.model.handleAction
import com.sacada.core.util.getStringAttribute
import com.sacada.ui.util.getIconResource
import kotlinx.serialization.json.JsonPrimitive

@Composable
fun RenderIcon(component: ViewComponent) {
    val iconName = remember { component.getStringAttribute("iconName") }
    val contentDescription = remember { component.getStringAttribute("contentDescription") }

    if (iconName.isNotEmpty()) {
        Box(
            modifier =
            Modifier.clickable {
                component.action?.let { handleAction(it) }
            }
        ) {
            Icon(
                imageVector = getIconResource(iconName),
                contentDescription = contentDescription
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRenderIcon() {
    val testComponent =
        ViewComponent(
            type = "IconButton",
            attributes =
            mapOf(
                "iconName" to JsonPrimitive("add"),
                "contentDescription" to JsonPrimitive("Adicionar")
            )
        )

    RenderIconButton(component = testComponent)
}
