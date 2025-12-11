package de.eller.kilian

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import de.eller.kilian.components.WithSharedTransitionScope

/**
 * Provides required scopes for preview
 *
 * Fakes animated content inside [WithSharedTransitionScope] to be always visible
 */
@Composable
fun ProvidePreviewScopes(
    content: @Composable () -> Unit,
) {
    AppTheme {
        SharedTransitionScope {
            AnimatedContent(true) {
                CompositionLocalProvider(
                    LocalSharedTransitionScope provides this@SharedTransitionScope,
                    LocalNavAnimatedContentScope provides this@AnimatedContent,
                    content = content,
                )
            }
        }
    }
}