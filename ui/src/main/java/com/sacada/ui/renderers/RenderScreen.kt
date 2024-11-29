package com.sacada.ui.renderers

import ViewScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RenderScreen(screen: ViewScreen) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            screen.topBar?.let { RenderTopBar(it) }
        },
        bottomBar = {
            screen.bottomBar?.let { RenderBottomBar(it) }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            screen.layout?.let { RenderComponent(it) }
        }
    }
}
