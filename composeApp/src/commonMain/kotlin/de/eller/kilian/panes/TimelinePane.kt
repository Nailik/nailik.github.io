package de.eller.kilian.panes

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HistoryEdu
import androidx.compose.material.icons.outlined.WorkHistory
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.AndroidUiModes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.eller.kilian.Education
import de.eller.kilian.Employer
import de.eller.kilian.LocalDarkModeScope
import de.eller.kilian.ProvidePreviewScopes
import de.eller.kilian.components.SkillChip
import de.eller.kilian.components.SkillChipWeight
import de.eller.kilian.components.TimeRangeText
import de.eller.kilian.components.WithSharedTransitionScope
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.education_title
import de.eller.kilian.resources.employer_title
import de.eller.kilian.resources.pane_timeline_title
import de.eller.kilian.resources.timeline_education_section_title
import de.eller.kilian.resources.timeline_employer_section_title
import org.jetbrains.compose.resources.stringResource
import kotlin.time.ExperimentalTime

/**
 * Timeline pane shows info about professional experience (employers) and Education
 *
 * @param selectedEmployers employment to be highlighted
 * @param showSinglePaneContent if the pane is shown without parent
 * @param onSelectEmployer action to execute on employer click
 */
@Composable
fun TimelinePane(
    selectedEmployers: Employer?,
    showSinglePaneContent: Boolean,
    onSelectEmployer: (Employer) -> Unit,
) {
    val paneTitleText = stringResource(Res.string.pane_timeline_title)
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .semantics {
                paneTitle = paneTitleText
            },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            stickyHeader {
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    ),
                    headlineContent = {
                        Text(
                            text = stringResource(Res.string.timeline_employer_section_title),
                        )
                    },
                    leadingContent = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Outlined.WorkHistory,
                            contentDescription = null,
                        )
                    }
                )
            }
            itemsIndexed(Employer.entries) { index, employer ->
                EmployerListItem(
                    showSinglePaneContent = showSinglePaneContent,
                    employer = employer,
                    selected = selectedEmployers == employer,
                    onClick = {
                        onSelectEmployer(employer)
                    },
                )
                if (index != Employer.entries.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .padding(horizontal = 8.dp),
                    )
                }
            }
            stickyHeader {
                ListItem(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    ),
                    headlineContent = {
                        Text(
                            text = stringResource(Res.string.timeline_education_section_title),
                        )
                    },
                    leadingContent = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Outlined.HistoryEdu,
                            contentDescription = null,
                        )
                    }
                )
            }
            itemsIndexed(Education.entries) { index, item ->
                WithSharedTransitionScope {
                    EducationListItem(
                        education = item,
                    )
                }
                if (index != Education.entries.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .padding(horizontal = 8.dp),
                    )
                }
            }
        }
    }
}

/**
 * Item that shows information about a previous or current employer
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalTime::class)
@Composable
private fun EmployerListItem(
    showSinglePaneContent: Boolean,
    employer: Employer,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val animateColorByState by animateColorAsState(if (selected && !showSinglePaneContent) MaterialTheme.colorScheme.onSurfaceVariant else Color.Transparent)
    val employerTitleText = stringResource(Res.string.employer_title)
    ListItem(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .border(
                width = 2.dp,
                color = animateColorByState,
                shape = MaterialTheme.shapes.small,
            )
            .clip(MaterialTheme.shapes.small)
            .clickable(
                onClick = onClick,
                role = Role.Button,
            )
            .pointerHoverIcon(PointerIcon.Hand)
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {
                contentDescription = employerTitleText
            },
        leadingContent = {
            WithSharedTransitionScope { animatedContentScope ->
                Image(
                    imageVector = when (LocalDarkModeScope.current) {
                        true -> employer.iconDarkMode
                        false -> employer.icon
                    },
                    modifier = Modifier
                        .sharedElement(
                            sharedContentState = rememberSharedContentState(key = "employer_logo_${employer.key}"),
                            animatedVisibilityScope = animatedContentScope,
                        )
                        .clip(MaterialTheme.shapes.small)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = MaterialTheme.shapes.small,
                        )
                        .padding(8.dp)
                        .size(56.dp),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                )
            }
        },
        overlineContent = {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier.semantics {
                        traversalIndex = 4f
                    },
                    text = stringResource(employer.jobDescription),
                )
                Text(
                    modifier = Modifier.semantics {
                        traversalIndex = 4f
                    },
                    text = stringResource(employer.location),
                )
            }
        },
        headlineContent = {
            Column(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                WithSharedTransitionScope { animatedContentScope ->
                    Text(
                        modifier = Modifier
                            .semantics {
                                traversalIndex = 2f
                                heading()
                            }
                            .sharedElement(
                                sharedContentState = rememberSharedContentState(key = "employer_company_${employer.key}"),
                                animatedVisibilityScope = animatedContentScope,
                            ),
                        text = stringResource(employer.company),
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth().semantics {
                            traversalIndex = 1f
                            heading()
                        },
                    text = stringResource(employer.jobTitle),
                    style = LocalTextStyle.current.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                )
            }
        },
        supportingContent = {
            Column(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                TimeRangeText(
                    modifier = Modifier.semantics {
                        traversalIndex = 3f
                    },
                    timeRange = employer.timeRange,
                )

                FlowRow(
                    modifier = Modifier
                        .semantics(mergeDescendants = true) {
                            traversalIndex = 6f
                        }
                        .fillMaxWidth()
                        .animateContentSize(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    employer.skills.forEach { skill ->
                        SkillChip(
                            skill = skill,
                            skillChipWeight = SkillChipWeight.Small,
                        )
                    }
                }
            }
        }
    )
}


/**
 * Item that shows information about a previous education step
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalTime::class)
@Composable
private fun EducationListItem(
    education: Education,
) {
    val educationTitleText = stringResource(Res.string.education_title)
    ListItem(
        modifier = Modifier.padding(horizontal = 8.dp)
            .clip(MaterialTheme.shapes.small)
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {
                contentDescription = educationTitleText
            },
        leadingContent = {
            Image(
                imageVector = education.icon,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = MaterialTheme.shapes.small,
                    )
                    .padding(8.dp)
                    .size(56.dp),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
        },
        overlineContent = {
            Text(
                modifier = Modifier.semantics {
                    traversalIndex = 4f
                },
                text = stringResource(education.field),
            )
        },
        headlineContent = {
            Column(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .semantics(mergeDescendants = true) {
                        traversalIndex = 5f
                    },
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Text(
                    modifier = Modifier
                        .semantics {
                            traversalIndex = 1f
                            heading()
                        },
                    text = stringResource(education.university),
                )
                if (education.degree != null) {
                    Text(
                        modifier = Modifier.semantics {
                            traversalIndex = 2f
                        },
                        text = stringResource(education.degree),
                        style = LocalTextStyle.current.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }
            }
        },
        supportingContent = {
            Column(
                modifier = Modifier.padding(vertical = 8.dp)
                    .semantics(mergeDescendants = true) {
                        traversalIndex = 5f
                    },
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                if (education.description != null) {
                    Text(
                        modifier = Modifier.semantics {
                            traversalIndex = 3f
                        },
                        text = stringResource(education.description),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
                TimeRangeText(
                    modifier = Modifier.semantics {
                        traversalIndex = 3f
                    },
                    timeRange = education.timeRange,
                )
                if (education.skills != null) {
                    FlowRow(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .semantics(mergeDescendants = true) {
                                traversalIndex = 6f
                            },
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        education.skills.forEach { skill ->
                            SkillChip(
                                skill = skill,
                                skillChipWeight = SkillChipWeight.Small,
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(uiMode = AndroidUiModes.UI_MODE_NIGHT_YES)
@Composable
private fun TimelinePaneDarkPreview() {
    ProvidePreviewScopes {
        TimelinePane(
            selectedEmployers = null,
            showSinglePaneContent = true,
            onSelectEmployer = {},
        )
    }
}

@Preview(uiMode = AndroidUiModes.UI_MODE_NIGHT_NO)
@Composable
private fun TimelinePaneLightPreview() {
    ProvidePreviewScopes {
        TimelinePane(
            selectedEmployers = null,
            showSinglePaneContent = true,
            onSelectEmployer = {},
        )
    }
}