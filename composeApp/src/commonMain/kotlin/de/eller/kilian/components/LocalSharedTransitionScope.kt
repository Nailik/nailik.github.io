package de.eller.kilian.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.LookaheadScope
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import de.eller.kilian.LocalSharedTransitionScope

/**
 * Provide the LocalSharedTransitionScope inside a SharedTransitionLayout in order
 * to animate elements across screens
 */
@Composable
fun ProvideSharedTransitionScope(
    content: @Composable () -> Unit,
) {
    SharedTransitionLayout {
        CompositionLocalProvider(
            LocalSharedTransitionScope provides this,
            content = content
        )
    }
}

/**
 * Wraps the compose content inside a SharedTransitionScope
 *
 * @param visible defines if this element should be visible
 * (all other references are required to be invisible)
 * @param enabled enable or disable this transition
 * @param block content to be displayed
 */
@Composable
fun WithSharedTransitionScope(
    visible: Boolean = true,
    enabled: Boolean = true,
    block: @Composable SharedTransitionScope.(AnimatedContentScope) -> Unit
) {
    if (visible) {
        val animatedContentScope = LocalNavAnimatedContentScope.current
        val realScope = LocalSharedTransitionScope.current
        val scope = if (enabled) {
            realScope
        } else {
            // create a disabled scope that delegates LookaheadScope behaviour to the real scope
            remember(realScope) { DisabledSharedTransitionScopeImpl(realScope as LookaheadScope) }
        }

        with(scope) {
            block(animatedContentScope)
        }
    }
}