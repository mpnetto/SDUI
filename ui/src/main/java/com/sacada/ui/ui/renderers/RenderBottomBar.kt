package com.sacada.ui.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.serialization.json.JsonPrimitive

@Composable
fun RenderBottomBar(component: ViewComponent) {
    val fabComponent = remember { component.children.find { it.type == "FloatingActionButton" } }
    val actions = createActionsComposable(component)
    val floatingActionButton = createFloatingActionButtonComposable(fabComponent)

    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = actions,
        floatingActionButton = floatingActionButton
    )
}

@Composable
private fun createActionsComposable(component: ViewComponent): @Composable RowScope.() -> Unit = {
    component.children.filter { it.type == "Action" }.forEach { actionComponent ->
        RenderIconButton(actionComponent)
    }
}

@Composable
private fun createFloatingActionButtonComposable(
    fabComponent: ViewComponent?
): @Composable () -> Unit = {
    fabComponent?.let {
        RenderComponent(it)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRenderBottomBar() {
    val sampleComponent =
        ViewComponent(
            type = "BottomBar",
            children =
            listOf(
                ViewComponent(
                    type = "Action",
                    attributes =
                    mapOf(
                        "iconName" to JsonPrimitive("home"),
                        "contentDescription" to JsonPrimitive("Home")
                    )
                ),
                ViewComponent(
                    type = "FloatingActionButton",
                    attributes =
                    mapOf(
                        "iconName" to JsonPrimitive("add"),
                        "contentDescription" to JsonPrimitive("Adicionar")
                    )
                )
            )
        )
    RenderBottomBar(component = sampleComponent)
}
