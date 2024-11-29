package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sacada.core.util.getStringAttribute
import com.sacada.util.getPadding
import com.sacada.util.getTextStyle
import kotlinx.serialization.json.JsonPrimitive

@Composable
fun RenderText(component: ViewComponent) {
    val style = component.getTextStyle()
    val padding = remember { component.getPadding() }

    Text(
        text = component.getStringAttribute("content"),
        style = style,
        modifier = Modifier.padding(0.dp, padding),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true, widthDp = 200)
@Composable
fun PreviewRenderText() {
    val testComponent = ViewComponent(
        type = "Text",
        attributes = mapOf(
            "content" to JsonPrimitive("Olá, este é um texto de exemplo!"),
            "style" to JsonPrimitive("title")
        )
    )

    MaterialTheme {
        RenderText(component = testComponent)
    }
}