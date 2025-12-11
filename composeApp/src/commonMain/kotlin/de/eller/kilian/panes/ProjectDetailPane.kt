package de.eller.kilian.panes

import androidx.compose.animation.animateBounds
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import de.eller.kilian.Project
import de.eller.kilian.ProvidePreviewScopes
import de.eller.kilian.components.AutoScrollCarousel
import de.eller.kilian.components.BulletElevatedCard
import de.eller.kilian.components.BulletOutlinedCard
import de.eller.kilian.components.EqualSizeFlowRow
import de.eller.kilian.components.SkillChip
import de.eller.kilian.components.SkillChipWeight
import de.eller.kilian.components.WithSharedTransitionScope
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.button_google_play
import de.eller.kilian.resources.icon_back
import org.jetbrains.compose.resources.stringResource

/**
 * Detail information of a private open source project
 *
 * @param project data to be displayed
 * @param showSinglePaneContent if the pane is shown without parent
 * @param onNavigateBack action to execute on app bar back click
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ProjectDetailPane(
    project: Project,
    showSinglePaneContent: Boolean,
    onNavigateBack: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    WithSharedTransitionScope(
                        enabled = showSinglePaneContent
                    ) { animatedContentScope ->
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .sharedElement(
                                    sharedContentState = rememberSharedContentState(key = "project_title_${project.key}"),
                                    animatedVisibilityScope = animatedContentScope,
                                ),
                            text = stringResource(project.title),
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
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(Res.string.icon_back),
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            tonalElevation = 12.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                AutoScrollCarousel(
                    modifier = Modifier.height(400.dp),
                    initialImageAnimationContentState = if (showSinglePaneContent) "project_image_${project.key}" else null,
                    images = project.thumbnails,
                    maxItemWidth = 450.dp,
                )

                if (showSinglePaneContent) {
                    WithSharedTransitionScope { animatedContentScope ->
                        FlowRow(
                            modifier = Modifier
                                .semantics(mergeDescendants = true) {}
                                .sharedElement(
                                    sharedContentState = rememberSharedContentState(key = "project_skills_${project.key}"),
                                    animatedVisibilityScope = animatedContentScope,
                                ),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                        ) {
                            project.skills.forEach { skill ->
                                SkillChip(
                                    skill = skill,
                                    skillChipWeight = SkillChipWeight.Small,
                                )
                            }
                        }
                    }
                }

                Column(
                    modifier = Modifier.widthIn(max = 600.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(project.introduction),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    val uriHandler = LocalUriHandler.current
                    Button(
                        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                        onClick = { uriHandler.openUri(project.url) },
                    ) {
                        Icon(
                            modifier = Modifier.padding(end = 8.dp),
                            imageVector = Icons.Default.Shop,
                            contentDescription = null,
                        )
                        Text(stringResource(Res.string.button_google_play))
                    }
                }

                if (project.outcome != null) {
                    BulletElevatedCard(project.outcome)
                }

                if (project.bulletCardData.isNotEmpty()) {
                    EqualSizeFlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalSpacing = 16.dp,
                        verticalSpacing = 16.dp,
                    ) {
                        LookaheadScope {
                            project.bulletCardData.forEach { bulletData ->
                                BulletOutlinedCard(
                                    modifier = Modifier.animateBounds(this),
                                    bulletCardData = bulletData
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private class ProjectPreviewProvider : PreviewParameterProvider<Project> {
    override val values = Project.entries.asSequence()
}


@Preview(widthDp = 1600, heightDp = 1800)
@Composable
private fun ProjectDetailPanePreview(
    @PreviewParameter(ProjectPreviewProvider::class) project: Project
) {
    ProvidePreviewScopes {
        ProjectDetailPane(
            project = project,
            showSinglePaneContent = true,
            onNavigateBack = {},
        )
    }
}

