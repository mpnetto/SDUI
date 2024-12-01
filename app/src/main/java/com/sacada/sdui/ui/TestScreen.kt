package com.sacada.sdui.ui

import androidx.compose.runtime.Composable
import com.sacada.core.util.JsonParser
import com.sacada.sdui.test.samplePayload
import com.sacada.ui.ui.screen.RenderScreen

@Composable
fun TestScreen() {
    val rootComponent = JsonParser.parseScreen(samplePayload)
    RenderScreen(rootComponent)
}
