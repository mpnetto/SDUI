package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun RenderTextField(component: ViewComponent) {
    val textValue = remember { mutableStateOf("") }
    Column {
        Text(text = component.attributes["label"]?.jsonPrimitive?.content ?: "")
        TextField(
            placeholder = { Text(text = component.attributes["placeholder"]?.jsonPrimitive?.content ?: "") },
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