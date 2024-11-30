package com.sacada.ui.ui.renderers

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
import com.sacada.core.util.isValid
import com.sacada.ui.ui.screen.LocalScreenViewModel
import com.sacada.ui.util.parseJson

@Composable
fun RenderTextField(component: ViewComponent) {
    val viewModel = LocalScreenViewModel.current
    val textValue = remember { mutableStateOf("") }
    val isValid = remember { mutableStateOf(component.isValid("")) }

    Column {
        Text(text = component.getStringAttribute("label"))
        TextField(
            placeholder = { Text(text = component.getStringAttribute("placeholder")) },
            value = textValue.value,
            isError = !isValid.value,
            onValueChange = {
                textValue.value = it
                isValid.value = component.isValid(it)
                viewModel.updateComponentState(component.id, isValid.value)
            })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRenderTextField() {
    val testComponent = """
        {
          "id": "usernameField",
          "type": "TextField",
          "attributes": {
            "placeholder": "Enter your username",
            "validation": {
              "required": true,
              "minLength": 5,
              "regex": "^[a-zA-Z0-9_]*${'$'}"
            }
          }
        }
    """.parseJson()

    MaterialTheme {
        RenderTextField(component = testComponent)
    }
}