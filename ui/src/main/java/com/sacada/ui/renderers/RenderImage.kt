package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.sacada.core.util.getStringAttribute

@Composable
fun RenderImage(component: ViewComponent) {
    val resourceId = component.getStringAttribute("resourceId").toIntOrNull()
    val contentDescription = component.getStringAttribute("contentDescription")

    if (resourceId != null) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
    }
}