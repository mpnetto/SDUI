package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sacada.core.model.handleAction
import com.sacada.util.getIconResource
import kotlinx.serialization.json.jsonPrimitive


@Composable
fun RenderIcon(component: ViewComponent) {

    val iconName = component.attributes["iconName"]?.jsonPrimitive?.content
    val contentDescription = component.attributes["contentDescription"]?.jsonPrimitive?.content ?: ""


    if (iconName != null) {
        Box(
            modifier = Modifier.clickable {
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