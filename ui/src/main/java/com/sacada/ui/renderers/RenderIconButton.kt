package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.sacada.core.model.handleAction


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