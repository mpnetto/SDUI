package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.sacada.core.model.handleAction
import com.sacada.core.util.getStringAttribute
import com.sacada.util.getIconResource


@Composable
fun RenderFloatingActionButton(component: ViewComponent) {

    val iconName = remember { component.getStringAttribute("iconName") }
    val contentDescription = remember { component.getStringAttribute("contentDescription") }

    FloatingActionButton(
        onClick = {
            component.action?.let { handleAction(it) }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        if (iconName.isNotEmpty()) {
            Icon(
                imageVector = getIconResource(iconName),
                contentDescription = contentDescription
            )
        }
    }
}

