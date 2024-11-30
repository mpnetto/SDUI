package com.sacada.ui.ui.screen

import ViewScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.sacada.ui.ui.renderers.RenderBottomBar
import com.sacada.ui.ui.renderers.RenderComponent
import com.sacada.ui.ui.renderers.RenderTopBar

@Composable
fun RenderScreen(screen: ViewScreen, viewModel: ScreenViewModel = hiltViewModel()) {
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
