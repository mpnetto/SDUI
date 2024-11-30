package com.sacada.ui.ui.renderers

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
import com.sacada.ui.util.getPadding
import com.sacada.ui.util.getTextStyle
import com.sacada.ui.util.parseJson

@Composable
fun RenderText(component: ViewComponent) {
    val textStyle = component.getTextStyle()
    val padding = remember { component.getPadding() }

    Text(
        text = component.getStringAttribute("content"),
        style = textStyle,
        modifier = Modifier.padding(0.dp, padding),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true, widthDp = 200)
@Composable
fun PreviewRenderText() {
    val testComponent = """
        {
            "id": "text1",
            "type": "Text",
            "attributes": {
                "content": "What are you interested in?",
                "style": {
                    "type": "titleLarge",
                    "color": "black"
                }
            }
        }
    """.parseJson()

    MaterialTheme {
        RenderText(component = testComponent)
    }
}