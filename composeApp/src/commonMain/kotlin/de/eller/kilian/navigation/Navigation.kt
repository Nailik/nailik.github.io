package de.eller.kilian.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuOpen
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.AppBarRow
import androidx.compose.material3.AppBarScope
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.WideNavigationRail
import androidx.compose.material3.WideNavigationRailItem
import androidx.compose.material3.WideNavigationRailState
import androidx.compose.material3.WideNavigationRailValue
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.layout.calculatePaneScaffoldDirective
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuite
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.material3.rememberWideNavigationRailState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXPANDED_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import de.eller.kilian.Languages
import de.eller.kilian.NavItems
import de.eller.kilian.Social
import de.eller.kilian.components.ProvideSharedTransitionScope
import de.eller.kilian.customAppLocale
import de.eller.kilian.navigation.DetailEntry.EmployerDetailEntry
import de.eller.kilian.navigation.DetailEntry.LibraryDetailEntry
import de.eller.kilian.navigation.DetailEntry.ProjectDetailEntry
import de.eller.kilian.navigation.NavigationType.NavigationBar
import de.eller.kilian.navigation.NavigationType.NavigationRail
import de.eller.kilian.panes.AboutPane
import de.eller.kilian.panes.EmployerDetailPane
import de.eller.kilian.panes.HomePane
import de.eller.kilian.panes.LibraryDetailPane
import de.eller.kilian.panes.ProjectDetailPane
import de.eller.kilian.panes.ProjectsPane
import de.eller.kilian.panes.TimelinePane
import de.eller.kilian.resources.Res
import de.eller.kilian.resources.icon_show_more_description
import de.eller.kilian.resources.pane_home_name
import de.eller.kilian.resources.state_collapsed_description
import de.eller.kilian.resources.state_expanded_description
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/**
 * The NavigationLayout handles displaying the
 * AppBar
 * Content
 * AdaptiveNavigation (NavigationRail or NavigationBar)
 */
@OptIn(
    ExperimentalMaterial3ExpressiveApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalSharedTransitionApi::class
)
@Composable
fun NavigationLayout(
    backStack: SnapshotStateList<NavItem>,
) {
    val navigationSuiteType = calculateNavigationSuiteType()
    val initialNavigationRailState = navigationSuiteType.wideNavigationRailValue
    val state = rememberNavigationSuiteScaffoldState()
    val wideNavigationRailState = rememberWideNavigationRailState(initialNavigationRailState)

    LaunchedEffect(navigationSuiteType) {
        when (navigationSuiteType) {
            NavigationSuiteType.WideNavigationRailExpanded -> wideNavigationRailState.expand()
            NavigationSuiteType.WideNavigationRailCollapsed -> wideNavigationRailState.collapse()
            NavigationSuiteType.NavigationRail -> wideNavigationRailState.collapse()
        }
    }

    NavigationSuiteScaffoldLayout(
        navigationSuiteType = navigationSuiteType,
        state = state,
        navigationSuite = {
            NavigationSuite(
                navigationSuiteType = navigationSuiteType,
                wideNavigationRailState = wideNavigationRailState,
                backStack = backStack,
            )
        },
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    onOpenHomePane = {
                        backStack.add(HomeEntry)
                    }
                )
            }
        ) { paddingValues ->
            ProvideSharedTransitionScope {
                Content(
                    paddingValues = paddingValues,
                    navigationType = navigationSuiteType.navigationType,
                    backStack = backStack,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    onOpenHomePane: () -> Unit,
) {
    val textWidth = mutableStateOf(0)

    BoxWithConstraints {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clip(MaterialTheme.shapes.small)
                        .clickable(
                            onClick = onOpenHomePane,
                            role = Role.Button,
                        )
                        .padding(8.dp)
                        .onGloballyPositioned {
                            textWidth.value = it.size.width
                        },
                    text = stringResource(Res.string.pane_home_name),
                    maxLines = 1,
                )
            },
            actions = {
                TopAppBarActions(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .wrapContentWidth(Alignment.End)
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarActions(modifier: Modifier) {
    val uriHandler = LocalUriHandler.current
    AppBarRow(
        modifier = modifier,
        overflowIndicator = { state ->
            IconButton(
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                onClick = {
                    when (state.isShowing) {
                        true -> state.dismiss()
                        false -> state.show()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = stringResource(Res.string.icon_show_more_description),
                )
            }
        }
    ) {
        Social.entries.forEach { social ->
            navigationBarItem(
                title = social.title,
                icon = social.icon,
                hasColor = social.hasColor,
                onClick = { uriHandler.openUri(social.uri) }
            )
        }

        Languages.entries.forEach { language ->
            navigationBarItem(
                title = language.title,
                icon = language.icon,
                onClick = { customAppLocale = language.locale }
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
private fun AppBarScope.navigationBarItem(
    title: StringResource,
    icon: ImageVector,
    hasColor: Boolean = true,
    onClick: () -> Unit,
) {
    customItem(
        appbarContent = {
            TooltipBox(
                positionProvider = TooltipDefaults
                    .rememberTooltipPositionProvider(TooltipAnchorPosition.Above),
                tooltip = { PlainTooltip { Text(stringResource(title)) } },
                state = rememberTooltipState(),
            ) {
                IconButton(
                    modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                    onClick = onClick,
                ) {
                    val languageTitle = stringResource(title)
                    Image(
                        modifier = Modifier.size(24.dp),
                        imageVector = icon,
                        contentDescription = languageTitle,
                        contentScale = ContentScale.Fit,
                        colorFilter = if (!hasColor) {
                            ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                        } else null,
                    )
                }
            }
        },
        menuContent = {
            DropdownMenuItem(
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                text = { Text(stringResource(title)) },
                onClick = onClick,
            )
        },
    )
}

@Composable
private fun NavigationSuite(
    navigationSuiteType: NavigationSuiteType,
    wideNavigationRailState: WideNavigationRailState,
    backStack: SnapshotStateList<NavItem>,
) {
    //workaround, otherwise the navigation items do not render correctly
    val navItemsWithTitle = NavItems.entries.map { it to stringResource(it.title) }

    AdaptiveNavigationSuite(
        navigationSuiteType = navigationSuiteType,
        wideNavigationRailState = wideNavigationRailState,
        navigationContent = {
            //find selected item in backstack
            val selected = backStack.reversed()
                .firstOrNull { NavItems.entries.map { item -> item.destination }.contains(it) }
            navItemsWithTitle.forEach { (navItem, title) ->
                NavigationItem(
                    navigationSuiteType = navigationSuiteType,
                    railExpanded = wideNavigationRailState.currentValue == WideNavigationRailValue.Expanded,
                    title = title,
                    navItem = navItem,
                    selected = selected == navItem.destination,
                    onClick = {
                        backStack.apply {
                            clear()
                            add(navItem.destination)
                        }
                    },
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
private fun Content(
    paddingValues: PaddingValues,
    navigationType: NavigationType,
    backStack: SnapshotStateList<NavItem>,
) {
    Surface(
        modifier = Modifier
            //consume insets to prevent panes from consuming again
            .consumeWindowInsets(WindowInsets.systemBars)
            //padding values contain bottom padding but there should be no padding
            .padding(top = paddingValues.calculateTopPadding())
            .clip(
                MaterialTheme.shapes.large.let {
                    when (navigationType) {
                        NavigationRail -> it.copy(
                            bottomEnd = CornerSize(0.dp),
                        )

                        NavigationBar -> it.copy(
                            bottomStart = CornerSize(0.dp),
                            bottomEnd = CornerSize(0.dp),
                        )
                    }
                }
            ),
        tonalElevation = 6.dp,
    ) {
        val paneScaffoldDirective = calculatePaneScaffoldDirective(currentWindowAdaptiveInfoV2())
            .copy(horizontalPartitionSpacerSize = 0.dp)
        val isSinglePane = paneScaffoldDirective.maxHorizontalPartitions == 1

        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = persistentListOf(rememberSaveableStateHolderNavEntryDecorator()),
            sceneStrategies = persistentListOf(rememberListDetailSceneStrategy(directive = paneScaffoldDirective)),
            entryProvider = entryProvider {
                entry<HomeEntry> {
                    HomePane(
                        onOpenProjects = {
                            backStack.apply {
                                clear()
                                add(ProjectsEntry)
                            }
                        },
                        onOpenTimeline = {
                            backStack.apply {
                                clear()
                                add(TimelineEntry)
                            }
                        },
                    )
                }

                entry<ProjectsEntry>(
                    metadata = remember { ListDetailSceneStrategy.listPane(sceneKey = SCENE_PROJECTS) }
                ) {
                    ProjectsPane(
                        showSinglePaneContent = isSinglePane,
                        selectedProject = (backStack.last() as? ProjectDetailEntry)?.arg,
                        onSelectProject = { project ->
                            backStack.navigateToDetail(ProjectDetailEntry(project))
                        },
                    )
                }

                entry<TimelineEntry>(
                    metadata = remember { ListDetailSceneStrategy.listPane(sceneKey = SCENE_TIMELINE) }
                ) {
                    TimelinePane(
                        showSinglePaneContent = isSinglePane,
                        selectedEmployers = (backStack.last() as? EmployerDetailEntry)?.arg,
                        onSelectEmployer = { employer ->
                            backStack.navigateToDetail(EmployerDetailEntry(employer))
                        },
                    )
                }

                entry<AboutEntry>(
                    metadata = remember { ListDetailSceneStrategy.listPane(sceneKey = SCENE_LIBRARY) }
                ) {
                    AboutPane(
                        showSinglePaneContent = isSinglePane,
                        selectedLibrary = (backStack.last() as? LibraryDetailEntry)?.arg,
                        onSelectLibrary = { library ->
                            backStack.navigateToDetail(LibraryDetailEntry(library.uniqueId))
                        },
                    )
                }

                entry<LibraryDetailEntry>(
                    metadata = remember { ListDetailSceneStrategy.detailPane(sceneKey = SCENE_LIBRARY) }
                ) { (library) ->
                    LibraryDetailPane(
                        showSinglePaneContent = isSinglePane,
                        uniqueId = library,
                        onNavigateBack = { backStack.removeLastOrNull() },
                    )
                }

                entry<ProjectDetailEntry>(
                    metadata = remember { ListDetailSceneStrategy.detailPane(sceneKey = SCENE_PROJECTS) }
                ) { (project) ->
                    ProjectDetailPane(
                        project = project,
                        showSinglePaneContent = isSinglePane,
                        onNavigateBack = { backStack.removeLastOrNull() },
                    )
                }

                entry<EmployerDetailEntry>(
                    metadata = remember { ListDetailSceneStrategy.detailPane(sceneKey = SCENE_TIMELINE) }
                ) { (employer) ->
                    EmployerDetailPane(
                        employer = employer,
                        showSinglePaneContent = isSinglePane,
                        onNavigateBack = { backStack.removeLastOrNull() },
                    )
                }
            },
        )
    }
}


@Composable
private fun AdaptiveNavigationSuite(
    navigationSuiteType: NavigationSuiteType,
    wideNavigationRailState: WideNavigationRailState,
    navigationContent: @Composable () -> Unit,
) {
    when (navigationSuiteType.navigationType) {
        NavigationRail -> {
            WideNavigationRail(
                state = wideNavigationRailState,
                header = {
                    if(navigationSuiteType != NavigationSuiteType.NavigationRail) {
                        WideNavigationRailButton(
                            railState = wideNavigationRailState,
                        )
                    }
                },
                content = {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        navigationContent()
                    }
                }
            )
        }

        NavigationBar -> {
            NavigationSuite(
                navigationSuiteType = navigationSuiteType,
                content = navigationContent,
            )
        }
    }
}

/**
 * NavigationItem for specific navItem
 */
@Composable
private fun NavigationItem(
    railExpanded: Boolean,
    title: String,
    navItem: NavItems,
    selected: Boolean,
    onClick: () -> Unit,
    navigationSuiteType: NavigationSuiteType,
) {
    AdaptiveNavigationItem(
        selected = selected,
        onClick = onClick,
        icon = {
            AnimatedContent(
                targetState = selected,
                transitionSpec = {
                    (fadeIn(animationSpec = tween(220, delayMillis = 90)))
                        .togetherWith(fadeOut(animationSpec = tween(90)))
                },
            ) { isSelected ->
                if (isSelected) {
                    Icon(
                        navItem.iconSelected,
                        contentDescription = title,
                    )
                } else {
                    Icon(
                        navItem.icon,
                        contentDescription = title,
                    )
                }
            }
        },
        label = {
            Text(
                text = title,
            )
        },
        railExpanded = railExpanded,
        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
        navigationSuiteType = navigationSuiteType,
    )
}


/**
 * Adaptive navigation item to be shown in Bar or Rail
 */
@Composable
private fun AdaptiveNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: @Composable (() -> Unit)?,
    railExpanded: Boolean,
    modifier: Modifier = Modifier,
    navigationSuiteType: NavigationSuiteType,
) {
    when (navigationSuiteType.navigationType) {
        NavigationRail -> WideNavigationRailItem(
            selected = selected,
            onClick = onClick,
            icon = icon,
            label = label,
            railExpanded = railExpanded,
            modifier = modifier,
        )

        NavigationBar -> NavigationSuiteItem(
            selected = selected,
            onClick = onClick,
            icon = icon,
            label = label,
            modifier = modifier,
            navigationSuiteType = navigationSuiteType,
        )
    }
}

@Composable
private fun WideNavigationRailButton(
    railState: WideNavigationRailState,
) {
    val scope = rememberCoroutineScope()

    val stateDescriptionText = if (railState.expanding) {
        stringResource(Res.string.state_expanded_description)
    } else stringResource(Res.string.state_collapsed_description)

    IconButton(
        modifier =
            Modifier
                .pointerHoverIcon(PointerIcon.Hand)
                .padding(start = 24.dp, bottom = 8.dp)
                .semantics {
                    stateDescription = stateDescriptionText
                },
        onClick = { scope.launch { railState.toggle() } },
    ) {
        var rotationTarget by remember { mutableStateOf(0f) }

        LaunchedEffect(railState.currentValue, railState.isAnimating) {
            if (railState.isAnimating && railState.currentValue != railState.targetValue) {
                rotationTarget += if (railState.targetValue == WideNavigationRailValue.Expanded) (360f - rotationTarget) else -180f
            }
        }

        val animatedRotation by animateFloatAsState(
            targetValue = rotationTarget,
            animationSpec = tween(220)
        )

        AnimatedContent(
            targetState = railState.expanding,
            modifier = Modifier
                .rotate(animatedRotation),
        ) { expanded ->
            if (expanded) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.MenuOpen,
                    contentDescription = null,
                    modifier = Modifier.rotate(180f)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = null,
                )
            }
        }
    }
}

private inline fun <reified T : DetailEntry> SnapshotStateList<NavItem>.navigateToDetail(key: T) {
    if (last() != key) {
        apply {
            removeAll { T::class.isInstance(it) }
            add(key)
        }
    }
}

@Composable
private fun calculateNavigationSuiteType() = with(currentWindowAdaptiveInfo()) {
    when (windowSizeClass.minWidthDp) {
        0 -> NavigationSuiteType.ShortNavigationBarCompact
        WIDTH_DP_MEDIUM_LOWER_BOUND -> NavigationSuiteType.ShortNavigationBarMedium
        WIDTH_DP_EXPANDED_LOWER_BOUND -> when {
            windowSizeClass.minHeightDp < HEIGHT_DP_MEDIUM_LOWER_BOUND -> NavigationSuiteType.NavigationRail
            else ->  NavigationSuiteType.WideNavigationRailCollapsed
        }
        else -> when {
            windowSizeClass.minHeightDp < HEIGHT_DP_MEDIUM_LOWER_BOUND -> NavigationSuiteType.NavigationRail
            else ->  NavigationSuiteType.WideNavigationRailExpanded
        }
    }
}

private val NavigationSuiteType.wideNavigationRailValue: WideNavigationRailValue
    get() = when {
        this == NavigationSuiteType.WideNavigationRailExpanded -> WideNavigationRailValue.Expanded
        else -> WideNavigationRailValue.Collapsed
    }

enum class NavigationType {
    NavigationRail,
    NavigationBar;
}

private val NavigationSuiteType.navigationType: NavigationType
    get() =
        if (this == NavigationSuiteType.WideNavigationRailCollapsed ||
            this == NavigationSuiteType.WideNavigationRailExpanded ||
            this == NavigationSuiteType.NavigationRail
        ) NavigationRail else NavigationBar


private val WideNavigationRailState.expanding: Boolean
    get() = (this.isAnimating && this.targetValue == WideNavigationRailValue.Expanded) || this.currentValue == WideNavigationRailValue.Expanded