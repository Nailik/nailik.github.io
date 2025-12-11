package de.eller.kilian

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.github.terrakok.navigation3.browser.ChronologicalBrowserNavigation
import com.github.terrakok.navigation3.browser.buildBrowserHistoryFragment
import com.github.terrakok.navigation3.browser.getBrowserHistoryFragmentName
import com.github.terrakok.navigation3.browser.getBrowserHistoryFragmentParameters
import de.eller.kilian.navigation.AboutEntry
import de.eller.kilian.navigation.DetailEntry.EmployerDetailEntry
import de.eller.kilian.navigation.DetailEntry.LibraryDetailEntry
import de.eller.kilian.navigation.DetailEntry.ProjectDetailEntry
import de.eller.kilian.navigation.HomeEntry
import de.eller.kilian.navigation.NavItem
import de.eller.kilian.navigation.ProjectsEntry
import de.eller.kilian.navigation.TimelineEntry

/**
 * Entrypoint for wasm js
 * handles browser back navigation and uri bar
 */
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(
        content = {
            val backStack = remember { mutableStateListOf<NavItem>(HomeEntry) }
            BrowserNavigation(backStack)
            App(
                backStack = backStack,
            )
        }
    )
}

@Composable
private fun BrowserNavigation(
    backStack: SnapshotStateList<NavItem>,
) {
    ChronologicalBrowserNavigation(
        backStack = backStack,
        saveKey = { key ->
            when (key) {
                AboutEntry -> buildBrowserHistoryFragment("about")
                is LibraryDetailEntry -> buildBrowserHistoryFragment(
                    name = "library",
                    parameters = mapOf("id" to key.arg)
                )

                is ProjectDetailEntry -> buildBrowserHistoryFragment(
                    name = "project",
                    parameters = mapOf("id" to key.arg.key)
                )

                is EmployerDetailEntry -> buildBrowserHistoryFragment(
                    name = "employer",
                    parameters = mapOf("id" to key.arg.key)
                )

                HomeEntry -> buildBrowserHistoryFragment("home")
                ProjectsEntry -> buildBrowserHistoryFragment("projects")
                TimelineEntry -> buildBrowserHistoryFragment("timeline")
            }
        },
        restoreKey = { fragment ->
            when (getBrowserHistoryFragmentName(fragment)) {
                "about" -> AboutEntry
                "library" -> LibraryDetailEntry(
                    getBrowserHistoryFragmentParameters(fragment)
                        .getValue("id") ?: error("id is required")
                )

                "project" -> ProjectDetailEntry(
                    Project.entries.firstOrNull {
                        it.key == getBrowserHistoryFragmentParameters(fragment)
                            .getValue("id")
                    } ?: error("id is required")
                )

                "employer" -> EmployerDetailEntry(
                    Employer.entries.firstOrNull {
                        it.key == getBrowserHistoryFragmentParameters(fragment)
                            .getValue("id")
                    } ?: error("id is required")
                )

                "home" -> HomeEntry
                "projects" -> ProjectsEntry
                "timeline" -> TimelineEntry
                else -> null
            }
        }
    )
}