package de.eller.kilian.panes

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.eller.kilian.Project
import de.eller.kilian.ProvidePreviewScopes
import de.eller.kilian.components.EqualSizeFlowRow
import de.eller.kilian.components.InformationChip
import de.eller.kilian.components.SkillChip
import de.eller.kilian.components.SkillChipWeight
import de.eller.kilian.components.WithSharedTransitionScope
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.pane_timeline_title
import de.eller.kilian.resources.project_contribution
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

/**
 * Overview of my open source projects
 *
 * @param selectedProject project to be highlighted
 * @param showSinglePaneContent if the pane is shown without parent
 * @param onSelectProject action to execute on project click
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectsPane(
    selectedProject: Project?,
    showSinglePaneContent: Boolean,
    onSelectProject: (Project) -> Unit,
) {
    val paneTitleText = stringResource(Res.string.pane_timeline_title)
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .semantics {
                paneTitle = paneTitleText
            },
    ) {
        EqualSizeFlowRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp)
                .animateContentSize(),
        ) {
            Project.entries.forEach { project ->
                ProjectCard(
                    modifier = Modifier
                        .padding(8.dp),
                    showSinglePaneContent = showSinglePaneContent,
                    project = project,
                    selected = project == selectedProject,
                    onClick = { onSelectProject(project) },
                )
            }
        }
    }
}

/**
 * Card for project information
 */
@Composable
private fun ProjectCard(
    modifier: Modifier,
    showSinglePaneContent: Boolean,
    project: Project,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val animateColorByState by animateColorAsState(if (selected && !showSinglePaneContent) MaterialTheme.colorScheme.onSurfaceVariant else Color.Transparent)
    val uriHandler = LocalUriHandler.current
    ElevatedCard(
        onClick = {
            if (project.skipDetail) {
                uriHandler.openUri(project.url)
            } else {
                onClick()
            }
        },
        modifier = modifier
            .widthIn(max = 450.dp)
            .border(
                width = 2.dp,
                color = animateColorByState,
                shape = CardDefaults.elevatedShape,
            )
            .fillMaxSize()
            .pointerHoverIcon(PointerIcon.Hand)
            .semantics(mergeDescendants = true) {}
    ) {
        ProjectImage(
            project = project,
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            WithSharedTransitionScope { animatedContentScope ->
                Text(
                    modifier = Modifier
                        .semantics { heading() }
                        .fillMaxWidth()
                        .sharedElement(
                            sharedContentState = rememberSharedContentState(key = "project_title_${project.key}"),
                            animatedVisibilityScope = animatedContentScope,
                        ),
                    text = stringResource(project.title),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            ProjectDescription(
                project = project,
            )
            Spacer(modifier = Modifier.heightIn(min = 16.dp).weight(1f))
            ProjectSkills(
                project = project,
            )
        }
    }
}

@Composable
private fun ProjectDescription(
    project: Project,
) {
    WithSharedTransitionScope { animatedContentScope ->
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .sharedElement(
                    sharedContentState = rememberSharedContentState(key = "project_description_${project.key}"),
                    animatedVisibilityScope = animatedContentScope,
                ),
            text = stringResource(project.description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun ProjectSkills(
    modifier: Modifier = Modifier,
    project: Project,
) {
    WithSharedTransitionScope { animatedContentScope ->
        FlowRow(
            modifier = modifier
                .semantics(mergeDescendants = true) {
                    traversalIndex = 6f
                }
                .fillMaxWidth()
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

@Composable
private fun ProjectImage(
    project: Project,
) {
    WithSharedTransitionScope { animatedContentScope ->
        Box(
            modifier = Modifier
                .padding(16.dp)
                .aspectRatio(2f)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .sharedElement(
                    sharedContentState = rememberSharedContentState(key = "project_image_${project.key}"),
                    animatedVisibilityScope = animatedContentScope,
                ),
            contentAlignment = Alignment.TopStart,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.small),
                painter = painterResource(project.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            if (project.isContribution) {
                InformationChip(
                    modifier = Modifier.padding(8.dp),
                    label = {
                        Text(
                            text = stringResource(Res.string.project_contribution),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors().copy(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        trailingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    ),
                )
            }
        }
    }
}

@Preview(widthDp = 1600, heightDp = 1800)
@Composable
private fun ProjectsPanePreview() {
    ProvidePreviewScopes {
        ProjectsPane(
            selectedProject = null,
            showSinglePaneContent = true,
            onSelectProject = {},
        )
    }
}