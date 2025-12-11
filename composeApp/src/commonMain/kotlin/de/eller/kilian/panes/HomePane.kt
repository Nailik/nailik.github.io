package de.eller.kilian.panes

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SpaceDashboard
import androidx.compose.material.icons.outlined.ViewTimeline
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.eller.kilian.Employer
import de.eller.kilian.LocalDarkModeScope
import de.eller.kilian.Project
import de.eller.kilian.ProvidePreviewScopes
import de.eller.kilian.Skill
import de.eller.kilian.components.EqualSizeFlowRow
import de.eller.kilian.components.SkillChip
import de.eller.kilian.components.SkillChipWeight
import de.eller.kilian.components.WithSharedTransitionScope
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.footer
import de.eller.kilian.resources.nav_item_title_projects
import de.eller.kilian.resources.pane_home_name
import de.eller.kilian.resources.profile_pic
import de.eller.kilian.resources.timeline_employer_section_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

/**
 * Home pane with information about myself
 * shows my skills and cards for projects and professional experience
 *
 * @param onOpenProjects action to be executed when projects card was clicked
 * @param onOpenTimeline action to be executed when professional experience was clicked
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalSharedTransitionApi::class)
@Composable
fun HomePane(
    onOpenProjects: () -> Unit,
    onOpenTimeline: () -> Unit,
) {
    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier.weight(0.8f))

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(),
                horizontalArrangement = Arrangement.spacedBy(
                    36.dp, alignment = Alignment.CenterHorizontally
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Image(
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape),
                    painter = painterResource(Res.drawable.profile_pic),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    val currentEmployer = Employer.entries.first()
                    Text(
                        modifier = Modifier.semantics {
                            heading()
                        },
                        text = stringResource(Res.string.pane_home_name),
                        style = MaterialTheme.typography.headlineLarge,
                    )
                    Text(
                        modifier = Modifier.semantics {
                            traversalIndex = 2f
                            heading()
                        },
                        text = stringResource(currentEmployer.jobTitle),
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Image(
                            modifier = Modifier.size(48.dp),
                            imageVector = currentEmployer.icon,
                            contentDescription = null,
                        )

                        Text(
                            modifier = Modifier.semantics {
                                traversalIndex = 1f
                                heading()
                            },
                            text = stringResource(currentEmployer.company),
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.weight(0.4f),
            )

            EqualSizeFlowRow(
                modifier = Modifier.fillMaxWidth().animateContentSize(),
                horizontalSpacing = 16.dp,
                verticalSpacing = 16.dp,
            ) {
                Card(
                    modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                    onClick = onOpenProjects,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                vertical = 32.dp,
                                horizontal = 16.dp,
                            ),
                        verticalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.SpaceDashboard,
                            contentDescription = null,
                        )

                        Text(
                            text = stringResource(Res.string.nav_item_title_projects),
                            style = MaterialTheme.typography.headlineMedium,
                        )

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(
                                12.dp,
                                Alignment.CenterHorizontally
                            ),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            Project.entries.forEach { project ->
                                WithSharedTransitionScope { animatedContentScope ->
                                    Box(
                                        modifier = Modifier
                                            .clip(MaterialTheme.shapes.small)
                                            .sharedElement(
                                                sharedContentState = rememberSharedContentState(key = "project_image_${project.key}"),
                                                animatedVisibilityScope = animatedContentScope,
                                            )
                                    ) {
                                        Image(
                                            modifier = Modifier.size(48.dp)
                                                .clip(MaterialTheme.shapes.small),
                                            painter = painterResource(project.image),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                        )
                                    }
                                }
                            }
                        }

                    }
                }

                Card(
                    modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                    onClick = onOpenTimeline,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                vertical = 32.dp,
                                horizontal = 12.dp,
                            ),
                        verticalArrangement = Arrangement.spacedBy(
                            12.dp,
                            Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ViewTimeline,
                            contentDescription = null,
                        )

                        Text(
                            text = stringResource(Res.string.timeline_employer_section_title),
                            style = MaterialTheme.typography.headlineMedium,
                        )

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(
                                12.dp,
                                Alignment.CenterHorizontally
                            ),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            Employer.entries.forEach { employers ->
                                WithSharedTransitionScope { animatedContentScope ->
                                    Image(
                                        modifier = Modifier
                                            .size(48.dp)
                                            .sharedElement(
                                                sharedContentState = rememberSharedContentState(key = "employer_logo_${employers.key}"),
                                                animatedVisibilityScope = animatedContentScope,
                                            ),
                                        imageVector = if (LocalDarkModeScope.current) employers.iconDarkMode else employers.icon,
                                        contentDescription = null,
                                    )
                                }
                            }
                        }
                    }
                }
            }


            Spacer(
                modifier = Modifier.weight(0.4f),
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                FlowRow(
                    modifier = Modifier.widthIn(max = 1200.dp).animateContentSize(),
                    horizontalArrangement = Arrangement.spacedBy(
                        12.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Skill.entries.forEach { skill ->
                        SkillChip(
                            skill = skill,
                            skillChipWeight = SkillChipWeight.Large,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(Res.string.footer),
                style = MaterialTheme.typography.labelLargeEmphasized,
            )

        }
    }
}


@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun HomePanePreview() {
    ProvidePreviewScopes {
        HomePane(
            onOpenProjects = {},
            onOpenTimeline = {},
        )
    }
}