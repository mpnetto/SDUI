package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.sacada.core.util.getStringAttribute
import kotlinx.serialization.json.JsonPrimitive

@Composable
fun RenderTextField(component: ViewComponent) {
    val textValue = remember { mutableStateOf("") }
    Column {
        Text(text = component.getStringAttribute("label"))
        TextField(
            placeholder = { Text(text = component.getStringAttribute("placeholder")) },
            value = textValue.value,
            onValueChange = { textValue.value = it }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRenderTextField() {
    val testComponent = ViewComponent(
        type = "TextField",
        attributes = mapOf(
            "placeholder" to JsonPrimitive("Digite seu nome")
        )
    )

    MaterialTheme {
        RenderTextField(component = testComponent)
    }
}