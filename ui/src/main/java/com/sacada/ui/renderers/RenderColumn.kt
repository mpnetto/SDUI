package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun RenderColumn(component: ViewComponent) {
    val horizontalAlignment = when (component.attributes["horizontalAlignment"]?.jsonPrimitive?.content) {
        "CenterHorizontally" -> Alignment.CenterHorizontally
        "Start" -> Alignment.Start
        "End" -> Alignment.End
        else -> Alignment.Start
    }

    val verticalArrangement = when (component.attributes["verticalArrangement"]?.jsonPrimitive?.content) {
        "SpaceBetween" -> Arrangement.SpaceBetween
        "SpaceAround" -> Arrangement.SpaceAround
        "SpaceEvenly" -> Arrangement.SpaceEvenly
        else -> Arrangement.Top
    }

    val padding = component.attributes["padding"]?.jsonPrimitive?.content?.toIntOrNull()?.dp ?: 0.dp

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