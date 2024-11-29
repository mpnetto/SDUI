package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun RenderImage(component: ViewComponent) {
    val resourceId = component.attributes["resourceId"]?.jsonPrimitive?.content?.toIntOrNull()
    val contentDescription = component.attributes["contentDescription"]?.jsonPrimitive?.content

    if (resourceId != null) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
    }
}