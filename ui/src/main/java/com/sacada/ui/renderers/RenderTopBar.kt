package com.sacada.ui.renderers

import ViewComponent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import kotlinx.serialization.json.jsonPrimitive


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenderTopBar(component: ViewComponent ) {

    val barTitle = component.attributes["title"]?.jsonPrimitive?.content ?: ""
    val scrollBehavior =
        resolveScrollBehavior(component.attributes["scrollBehavior"]?.jsonPrimitive?.content)
    val appBar = resolveAppBarType(component.type)

    val title = @Composable {
        Text(
            text = barTitle, maxLines = 1, overflow = TextOverflow.Ellipsis
        )
    }

    val navigationIcon = @Composable {
        component.children.find { it.type == "navigationIcon" }?.let {
            RenderIconButton(it)
        }
    }

    val actions: @Composable RowScope.() -> Unit = {
        component.children.filter { it.type == "Action" }.forEach { actionComponent ->
            RenderIconButton(actionComponent)
        }
    }

    val colors = topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary
    )


    appBar(title, navigationIcon, actions, colors, scrollBehavior)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun resolveScrollBehavior(scrollBehaviorType: String?): TopAppBarScrollBehavior? {
    val appBarState = rememberTopAppBarState()
    return when (scrollBehaviorType) {
        "enterAlways" -> TopAppBarDefaults.enterAlwaysScrollBehavior(appBarState)
        "exitUntilCollapsed" -> TopAppBarDefaults.exitUntilCollapsedScrollBehavior(appBarState)
        "pinned" -> TopAppBarDefaults.pinnedScrollBehavior(appBarState)
        else -> null
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun resolveAppBarType(type: String): @Composable (
    title: @Composable () -> Unit, navigationIcon: @Composable () -> Unit, actions: @Composable RowScope.() -> Unit, colors: TopAppBarColors, scrollBehavior: TopAppBarScrollBehavior?
) -> Unit {
    return when (type) {
        "large" -> { title, navigationIcon, actions, colors, scrollBehavior ->
            LargeTopAppBar(
                title = title,
                navigationIcon = navigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = scrollBehavior
            )
        }

        "medium" -> { title, navigationIcon, actions, colors, scrollBehavior ->
            MediumTopAppBar(
                title = title,
                navigationIcon = navigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = scrollBehavior
            )
        }

        "center" -> { title, navigationIcon, actions, colors, scrollBehavior ->
            CenterAlignedTopAppBar(
                title = title,
                navigationIcon = navigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = scrollBehavior
            )
        }

        else -> { title, navigationIcon, actions, colors, scrollBehavior ->
            TopAppBar(
                title = title,
                navigationIcon = navigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = scrollBehavior
            )
        }
    }
}