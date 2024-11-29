package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sacada.core.util.getStringAttribute

@Composable
fun RenderColumn(component: ViewComponent) {
    val horizontalAlignment = when (component.getStringAttribute("horizontalAlignment")) {
        "CenterHorizontally" -> Alignment.CenterHorizontally
        "Start" -> Alignment.Start
        "End" -> Alignment.End
        else -> Alignment.Start
    }

    val verticalArrangement = when (component.getStringAttribute("verticalArrangement")) {
        "SpaceBetween" -> Arrangement.SpaceBetween
        "SpaceAround" -> Arrangement.SpaceAround
        "SpaceEvenly" -> Arrangement.SpaceEvenly
        else -> Arrangement.Top
    }

    val padding = component.getStringAttribute("padding").toIntOrNull()?.dp ?: 0.dp

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement
    ) {
        component.children.forEach { child ->
            RenderComponent(child)
        }
    }
}