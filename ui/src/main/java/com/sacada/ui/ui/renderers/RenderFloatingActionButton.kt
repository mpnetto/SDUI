package com.sacada.ui.ui.renderers

import ViewComponent
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.sacada.core.model.handleAction
import com.sacada.core.util.getStringAttribute
import com.sacada.ui.ui.screen.LocalScreenViewModel
import com.sacada.ui.util.getIconResource
import kotlinx.serialization.json.JsonPrimitive


@Composable
fun RenderFloatingActionButton(component: ViewComponent) {

    val viewModel = LocalScreenViewModel.current
    val allComponentsValid by viewModel.areAllComponentsValid.collectAsState()

    val iconName = remember { component.getStringAttribute("iconName") }
    val contentDescription = remember { component.getStringAttribute("contentDescription") }

    FloatingActionButton(
        onClick = {
            if (allComponentsValid) {
                component.action?.let { handleAction(it) }
            }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        if (iconName.isNotEmpty()) {
            Icon(
                imageVector = getIconResource(iconName),
                contentDescription = contentDescription
            )
        }
    }
}

@Preview
@Composable
fun PreviewRenderFloatingActionButton() {
    val sampleComponent = ViewComponent(
        type = "FloatingActionButton",
        attributes = mapOf(
            "iconName" to JsonPrimitive("arrow_forward"),
            "contentDescription" to JsonPrimitive("Add")
        )
    )
    RenderFloatingActionButton(component = sampleComponent)
}
