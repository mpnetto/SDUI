package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun RenderText(component: ViewComponent) {
    val style = when (component.attributes["style"]?.jsonPrimitive?.content) {
        "displayLarge" -> MaterialTheme.typography.displayLarge
        "displayMedium" -> MaterialTheme.typography.displayMedium
        "displaySmall" -> MaterialTheme.typography.displaySmall
        "headlineLarge" -> MaterialTheme.typography.headlineLarge
        "headlineMedium" -> MaterialTheme.typography.headlineMedium
        "headlineSmall" -> MaterialTheme.typography.headlineSmall
        "titleLarge" -> MaterialTheme.typography.titleLarge
        "titleMedium" -> MaterialTheme.typography.titleMedium
        "titleSmall" -> MaterialTheme.typography.titleSmall
        "bodyLarge" -> MaterialTheme.typography.bodyLarge
        "bodyMedium" -> MaterialTheme.typography.bodyMedium
        "bodySmall" -> MaterialTheme.typography.bodySmall
        "labelLarge" -> MaterialTheme.typography.labelLarge
        "labelMedium" -> MaterialTheme.typography.labelMedium
        "labelSmall" -> MaterialTheme.typography.labelSmall
        else -> MaterialTheme.typography.bodyMedium
    }

    val padding = component.attributes["padding"]?.jsonPrimitive?.content?.toIntOrNull()?.dp ?: 0.dp


    Text(
        text = component.attributes["content"]?.jsonPrimitive?.content ?: "",
        style = style,
        modifier = Modifier.padding(0.dp, padding),
        textAlign = TextAlign.Center
    )
}