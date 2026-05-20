package de.eller.kilian.panes

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import de.eller.kilian.Employer
import de.eller.kilian.LocalDarkModeScope
import de.eller.kilian.ProvidePreviewScopes
import de.eller.kilian.WorkProjects
import de.eller.kilian.components.AutoScrollCarousel
import de.eller.kilian.components.BulletElevatedCard
import de.eller.kilian.components.BulletOutlinedCard
import de.eller.kilian.components.EqualSizeFlowRow
import de.eller.kilian.components.SkillChip
import de.eller.kilian.components.SkillChipWeight
import de.eller.kilian.components.WithSharedTransitionScope
import de.eller.kilian.logos.LogoGooglePlayStore
import de.eller.kilian.logos.Logos
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.button_google_play
import de.eller.kilian.resources.icon_back
import org.jetbrains.compose.resources.stringResource

/**
 * Detail information of an employment
 *
 * @param employer data to be displayed
 * @param showSinglePaneContent if the pane is shown without parent
 * @param onNavigateBack action to execute on app bar back click
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployerDetailPane(
    employer: Employer,
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
                    Row(
                        modifier = Modifier.height(IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        WithSharedTransitionScope(
                            visible = showSinglePaneContent
                        ) { animatedContentScope ->
                            Image(
                                imageVector = when (LocalDarkModeScope.current) {
                                    true -> employer.iconDarkMode
                                    false -> employer.icon
                                },
                                modifier = Modifier.size(24.dp).sharedElement(
                                    sharedContentState = rememberSharedContentState(key = "employer_logo_${employer.key}"),
                                    animatedVisibilityScope = animatedContentScope,
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                            )
                        }
                        WithSharedTransitionScope(
                            enabled = showSinglePaneContent,
                        ) { animatedContentScope ->
                            Text(
                                modifier = Modifier.fillMaxWidth().sharedElement(
                                    sharedContentState = rememberSharedContentState(key = "employer_company_${employer.key}"),
                                    animatedVisibilityScope = animatedContentScope,
                                ),
                                text = stringResource(employer.company),
                            )
                        }
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
                            contentDescription = stringResource(Res.string.icon_back),
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        }) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            tonalElevation = 12.dp,
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                employer.projects.forEachIndexed { index, project ->
                    WorkProject(project)

                    if (index != employer.projects.lastIndex) {
                        HorizontalDivider()
                    }
                }

            }

        }
    }
}

@Composable
private fun WorkProject(
    project: WorkProjects,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (project.images.isNotEmpty()) {
            AutoScrollCarousel(
                modifier = Modifier.wrapContentHeight(),
                maxItemWidth = 224.dp,
                images = project.images,
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            FlowRow(
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


        Text(
            text = stringResource(project.introduction),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )

        if (project.playStoreUrl != null) {
            val uriHandler = LocalUriHandler.current
            Button(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .pointerHoverIcon(PointerIcon.Hand),
                onClick = { uriHandler.openUri(project.playStoreUrl) },
            ) {
                Image(
                    modifier = Modifier.padding(end = 8.dp),
                    imageVector = Logos.LogoGooglePlayStore,
                    contentDescription = null,
                )
                Text(stringResource(Res.string.button_google_play))
            }
        }


        EqualSizeFlowRow(
            modifier = Modifier.fillMaxWidth().animateContentSize(),
            horizontalSpacing = 16.dp,
            verticalSpacing = 16.dp,
        ) {
            project.bulletCardData.forEach { bulletData ->
                BulletOutlinedCard(
                    modifier = Modifier,
                    bulletCardData = bulletData,
                )
            }
        }

        BulletElevatedCard(project.impact)
    }
}

private class EmployerPreviewProvider : PreviewParameterProvider<Employer> {
    override val values = Employer.entries.asSequence()
}

@Preview(widthDp = 1600, heightDp = 1800)
@Composable
private fun EmployerDetailPanePreview(
    @PreviewParameter(EmployerPreviewProvider::class) employer: Employer,
) {
    ProvidePreviewScopes {
        EmployerDetailPane(
            employer = employer,
            showSinglePaneContent = true,
            onNavigateBack = { },
        )
    }
}