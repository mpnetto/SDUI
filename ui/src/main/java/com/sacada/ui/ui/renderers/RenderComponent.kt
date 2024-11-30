package com.sacada.ui.ui.renderers

import ViewComponent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.sacada.ui.ui.screen.ScreenViewModel

@Composable
fun RenderComponent(component: ViewComponent) {
    when (component.type) {
        "Text" -> RenderText(component)
        "Button" -> RenderButton(component)
        "Image" -> RenderImage(component)
        "Checkbox" -> RenderCheckbox(component)
        "TextField" -> RenderTextField(component)
        "Column" -> RenderColumn(component)
        "Row" -> RenderRow(component)
        "FloatingActionButton" -> RenderFloatingActionButton(component)
        "IconButton" -> RenderIconButton(component)
        else -> RenderUnsupported(component)
    }
}

@Composable
fun RenderUnsupported(component: ViewComponent) {
    Text(text = "Unsupported component: ${component.type}")
}