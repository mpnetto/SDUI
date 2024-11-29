package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sacada.core.util.getStringAttribute

@Composable
fun RenderRow(component: ViewComponent) {
    val horizontalArrangement = when (component.getStringAttribute("horizontalArrangement")) {
        "SpaceBetween" -> Arrangement.SpaceBetween
        "SpaceAround" -> Arrangement.SpaceAround
        "SpaceEvenly" -> Arrangement.SpaceEvenly
        "Start" -> Arrangement.Start
        "End" -> Arrangement.End
        "Center" -> Arrangement.Center
        else -> Arrangement.Start
    }

    val verticalAlignment = when (component.getStringAttribute("verticalAlignment")) {
        "Top" -> Alignment.Top
        "CenterVertically" -> Alignment.CenterVertically
        "Bottom" -> Alignment.Bottom
        else -> Alignment.CenterVertically
    }

    val padding = component.getStringAttribute("padding").toIntOrNull()?.dp ?: 0.dp

    Row(
        modifier = Modifier.padding(padding),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment
    ) {
        component.children.forEach { child ->
            RenderComponent(child)
        }
    }
}