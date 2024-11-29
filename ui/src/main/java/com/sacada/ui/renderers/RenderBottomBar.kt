package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun RenderBottomBar(component: ViewComponent) {

    val fabComponent = component.children.find { it.type == "FloatingActionButton" }

    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = {
            component.children.filter { it.type == "Action" }.forEach { actionComponent ->
                RenderIconButton(actionComponent)
            }
        },
        floatingActionButton = {
            fabComponent?.let {
                RenderComponent(it)
            }
        }
    )
}