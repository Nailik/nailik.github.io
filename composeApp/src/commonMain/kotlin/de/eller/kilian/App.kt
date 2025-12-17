package de.eller.kilian

import androidx.compose.animation.Crossfade
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import de.eller.kilian.navigation.HomeEntry
import de.eller.kilian.navigation.NavItem
import de.eller.kilian.navigation.NavigationLayout
import de.eller.kilian.theme.AppTypography
import de.eller.kilian.theme.darkScheme
import de.eller.kilian.theme.lightScheme

/**
 * Stores if currently dark mode is enabled, can be used to switch icons
 */
val LocalDarkModeScope = compositionLocalOf<Boolean> {
    error("Must be provided first")
}

/**
 * Stores transition scope in order to animate elements across screens
 */
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope> {
    error("Must be provided first")
}

/**
 * provides theming for app and previews
 *
 * @param darkMode can be used to overwrite dark mode (e.g. for preview)
 * @param content the content to be displayed
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun AppTheme(
    darkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialExpressiveTheme(
        colorScheme = if (darkMode) darkScheme else lightScheme,
        typography = AppTypography,
    ) {
        CompositionLocalProvider(
            LocalDarkModeScope provides darkMode,
        ) {
            content()
        }
    }
}

/**
 * App Entry point
 *
 * @param darkMode can be used to overwrite dark mode (e.g. for preview)
 * @param backStack the backstack to be displayed
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun App(
    darkMode: Boolean = isSystemInDarkTheme(),
    backStack: SnapshotStateList<NavItem> = remember { mutableStateListOf(HomeEntry) },
) {
    BoxWithConstraints {
        AppTheme(darkMode) {
            Surface {
                Crossfade(
                    targetState = customAppLocale,
                ) {
                    CompositionLocalProvider(
                        LocalAppLocale provides it,
                    ) {
                        NavigationLayout(
                            backStack = backStack,
                        )
                    }
                }
            }
        }
    }
}