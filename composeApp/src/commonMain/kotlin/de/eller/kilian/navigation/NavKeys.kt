package de.eller.kilian.navigation

import androidx.compose.runtime.Stable
import androidx.navigation3.runtime.NavKey
import de.eller.kilian.Employer
import de.eller.kilian.Project

@Stable
sealed interface NavItem : NavKey

data object HomeEntry : NavItem

data object ProjectsEntry : NavItem

data object TimelineEntry : NavItem

data object AboutEntry : NavItem

sealed interface DetailEntry : NavItem {

    data class ProjectDetailEntry(val arg: Project) : DetailEntry

    data class LibraryDetailEntry(val arg: String) : DetailEntry

    data class EmployerDetailEntry(val arg: Employer) : DetailEntry

}