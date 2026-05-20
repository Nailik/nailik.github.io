package de.eller.kilian.panes

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.entity.Library
import com.mikepenz.aboutlibraries.entity.License
import de.eller.kilian.components.WithSharedTransitionScope
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.icon_back
import org.jetbrains.compose.resources.stringResource

/**
 * Detail information of a library
 *
 * @param uniqueId id of library to be displayed
 * @param showSinglePaneContent if the pane is shown without parent
 * @param onNavigateBack action to execute on app bar back click
 */
@Composable
fun LibraryDetailPane(
    uniqueId: String,
    showSinglePaneContent: Boolean,
    onNavigateBack: () -> Unit,
) {
    val libraries by produceState<Libs?>(initialValue = null) {
        value = Libs.Builder()
            .withJson(Res.readBytes("files/libraries.json").decodeToString())
            .build()
    }

    AnimatedContent(
        targetState = libraries,
    ) { libs ->
        val library = libs?.libraries?.firstOrNull { it.uniqueId == uniqueId }
        when {
            library != null -> LibraryContent(
                showSinglePaneContent = showSinglePaneContent,
                library = library,
                onNavigateBack = onNavigateBack,
            )

            else -> {}
        }

    }
}

/**
 * Library legal content
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LibraryContent(
    showSinglePaneContent: Boolean,
    library: Library,
    onNavigateBack: () -> Unit,
) {
    val license = remember(library) { library.strippedLicenseContent }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    WithSharedTransitionScope(
                        enabled = showSinglePaneContent,
                    ) { animatedContentScope ->
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .sharedElement(
                                    sharedContentState = rememberSharedContentState(key = "library_title_${library.uniqueId}"),
                                    animatedVisibilityScope = animatedContentScope,
                                ),
                            text = library.name
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                ),
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                        onClick = onNavigateBack,
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = stringResource(Res.string.icon_back)
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            tonalElevation = 12.dp,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .widthIn(max = 960.dp)
                        .padding(16.dp),
                    text = license,
                )
            }
        }
    }
}

private val License.strippedLicenseContent: String?
    get() = licenseContent?.replace("<br />", "\n")?.replace("<br/>", "\n")

private val Library.strippedLicenseContent: String
    get() = licenses.joinToString(separator = "\n\n\n\n") {
        it.strippedLicenseContent ?: ""
    }