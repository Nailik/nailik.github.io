package de.eller.kilian.panes

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.hideFromAccessibility
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.entity.Library
import de.eller.kilian.components.InformationChip
import de.eller.kilian.components.WithSharedTransitionScope
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.library_title
import de.eller.kilian.resources.pane_about_title
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource

/**
 * Displays list of used libraries.
 *
 * Shows a loading indicator if libraries list loads longer than 200ms.
 * Each library can be clicked and invokes [onSelectLibrary].
 *
 * @param selectedLibrary currently selected library id to be highlighted
 * @param showSinglePaneContent if the pane is shown without parent
 * @param onSelectLibrary action to execute when a library is selected
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun AboutPane(
    selectedLibrary: String?,
    showSinglePaneContent: Boolean,
    onSelectLibrary: (Library) -> Unit,
) {
    val paneTitleText = stringResource(Res.string.pane_about_title)
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .semantics {
                paneTitle = paneTitleText
            },
    ) {
        val libraries by produceState<Libs?>(initialValue = null) {
            value = Libs.Builder()
                .withJson(Res.readBytes("files/libraries.json").decodeToString())
                .build()
        }

        AnimatedContent(
            targetState = libraries,
        ) { libs ->
            if (libs == null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    //only show loading if it takes longer than 200 ms
                    var showLoadingIndicator by remember { mutableStateOf(false) }
                    LaunchedEffect(Unit) {
                        delay(200)
                        showLoadingIndicator = true
                    }
                    val animatedAlpha by animateFloatAsState(if (showLoadingIndicator) 1f else 0f)
                    LoadingIndicator(
                        modifier = Modifier
                            .fillMaxSize(0.1f)
                            .widthIn(
                                min = 24.dp,
                                max = 240.dp,
                            )
                            .aspectRatio(1f)
                            .alpha(animatedAlpha)
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    item { Spacer(modifier = Modifier) }
                    itemsIndexed(libs.libraries) { index, item ->
                        val animateColorByState by animateColorAsState(if (item.uniqueId == selectedLibrary && !showSinglePaneContent) MaterialTheme.colorScheme.onSurfaceVariant else Color.Transparent)
                        LibrariesListItem(
                            modifier = Modifier
                                .border(
                                    width = 2.dp,
                                    color = animateColorByState,
                                    shape = MaterialTheme.shapes.small,
                                ),
                            library = item,
                            onClick = {
                                onSelectLibrary(item)
                            },
                        )
                        if (index != libs.libraries.lastIndex) {
                            HorizontalDivider(
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .padding(horizontal = 8.dp),
                            )
                        }
                    }
                    item { Spacer(modifier = Modifier) }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun LibrariesListItem(
    modifier: Modifier,
    library: Library,
    onClick: () -> Unit,
) {
    val libraryTitleText = stringResource(Res.string.library_title)
    ListItem(
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .clickable(
                onClick = onClick,
                role = Role.Button,
            )
            .pointerHoverIcon(PointerIcon.Hand)
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {
                contentDescription = libraryTitleText
            },
        headlineContent = {
            WithSharedTransitionScope { animatedContentScope ->
                Text(
                    modifier = Modifier
                        .semantics { heading() }
                        .fillMaxWidth()
                        .sharedElement(
                            sharedContentState = rememberSharedContentState(key = "library_title_${library.uniqueId}"),
                            animatedVisibilityScope = animatedContentScope,
                        ),
                    text = library.name,
                )
            }
        },
        trailingContent = {
            Text(
                modifier = Modifier.semantics {
                    hideFromAccessibility()
                },
                text = library.artifactVersion.orEmpty(),
            )
        },
        supportingContent = {
            Column(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Text(
                    text = library.author,
                )
                val description = library.description.orEmpty()
                Text(
                    modifier = Modifier.semantics {
                        if (description.isEmpty()) {
                            hideFromAccessibility()
                        }
                    },
                    text = description,
                )
                Spacer(Modifier.height(2.dp))
                InformationChip(
                    label = {
                        Text(
                            text = library.artifactId,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                )
            }
        }
    )
}

private val Library.author: String
    get() = developers.takeIf { it.isNotEmpty() }?.mapNotNull { it.name }?.joinToString(", ")
        ?: organization?.name ?: ""

@Preview
@Composable
private fun AboutPanePreview() {
    AboutPane(
        selectedLibrary = null,
        showSinglePaneContent = true,
        onSelectLibrary = {},
    )
}