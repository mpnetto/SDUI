package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.sacada.core.model.handleAction
import com.sacada.util.getIconResource
import kotlinx.serialization.json.jsonPrimitive


@Composable
fun RenderFloatingActionButton(component: ViewComponent) {

    val iconName = component.attributes["iconName"]?.jsonPrimitive?.content
    val contentDescription = component.attributes["contentDescription"]?.jsonPrimitive?.content ?: ""

    FloatingActionButton(
        onClick = {
            component.action?.let { handleAction(it) }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        if (iconName != null) {
            Icon(
                imageVector = getIconResource(iconName),
                contentDescription = contentDescription
            )
        }
    }
}

