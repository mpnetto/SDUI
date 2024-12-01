package com.sacada.ui.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sacada.core.util.getStringAttribute
import com.sacada.ui.util.getPadding

@Composable
fun RenderRow(component: ViewComponent) {
    val horizontalArrangement =
        remember {
            when (component.getStringAttribute("horizontalArrangement")) {
                "SpaceBetween" -> Arrangement.SpaceBetween
                "SpaceAround" -> Arrangement.SpaceAround
                "SpaceEvenly" -> Arrangement.SpaceEvenly
                "Start" -> Arrangement.Start
                "End" -> Arrangement.End
                "Center" -> Arrangement.Center
                else -> Arrangement.Start
            }
        }
    val verticalAlignment =
        remember {
            when (component.getStringAttribute("verticalAlignment")) {
                "Top" -> Alignment.Top
                "CenterVertically" -> Alignment.CenterVertically
                "Bottom" -> Alignment.Bottom
                else -> Alignment.CenterVertically
            }
        }

    val padding = remember { component.getPadding() }

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
