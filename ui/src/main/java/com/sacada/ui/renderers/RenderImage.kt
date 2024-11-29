package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.sacada.core.util.getStringAttribute

@Composable
fun RenderImage(component: ViewComponent) {
    val imageUrl = remember { component.getStringAttribute("imageUrl") }
    val contentDescription = remember { component.getStringAttribute("contentDescription") }

    if (imageUrl.isNotEmpty()) {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
    }
}