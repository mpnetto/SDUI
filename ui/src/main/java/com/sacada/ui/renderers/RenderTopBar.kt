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
fun RenderTopBar(component: ViewComponent) {

    val navigationIcon  = component.children.find { it.type == "navigationIcon" }

    val title = component.attributes["title"]?.jsonPrimitive?.content ?: ""

    val scrollBehavior = when (component.attributes["scrollBehavior"]?.jsonPrimitive?.content) {
        "enterAlways" -> TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
        "exitUntilCollapsed" -> TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
            rememberTopAppBarState()
        )

        "pinned" -> TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        else -> null
    }

    val appBar: @Composable (
        title: @Composable () -> Unit,
        navigationIcon: @Composable () -> Unit,
        actions: @Composable RowScope.() -> Unit,
        colors: TopAppBarColors,
        scrollBehavior: TopAppBarScrollBehavior?
    ) -> Unit = when (component.type) {
        "large" -> { topTitle, topNavigationIcon, actions, colors, topScrollBehavior ->
            LargeTopAppBar(
                title = topTitle,
                navigationIcon = topNavigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = topScrollBehavior
            )
        }

        "medium" -> { topTitle, topNavigationIcon, actions, colors, topScrollBehavior ->
            MediumTopAppBar(
                title = topTitle,
                navigationIcon = topNavigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = topScrollBehavior
            )
        }

        "center" -> { topTitle, topNavigationIcon, actions, colors, topScrollBehavior ->
            CenterAlignedTopAppBar(
                title = topTitle,
                navigationIcon = topNavigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = topScrollBehavior
            )
        }

        else -> { topTitle, topNavigationIcon, actions, colors, topScrollBehavior ->
            TopAppBar(
                title = topTitle,
                navigationIcon = topNavigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = topScrollBehavior
            )
        }
    }

    appBar(
        {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        {
            navigationIcon?.let{
                RenderIconButton(navigationIcon)
            }

        },
        {
            component.children.filter { it.type == "Action" }.forEach { actionComponent ->
                RenderIconButton(actionComponent)
            }
        },
        topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        scrollBehavior
    )
}