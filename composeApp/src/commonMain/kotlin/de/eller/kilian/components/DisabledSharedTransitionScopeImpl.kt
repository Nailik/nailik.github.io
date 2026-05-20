package de.eller.kilian.components

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.BoundsTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.SharedTransitionScope.OverlayClip
import androidx.compose.animation.SharedTransitionScope.PlaceholderSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

/**
 * Mocks SharedTransitionScope with disabled animations
 */
class DisabledSharedTransitionScopeImpl(
    private val lookaheadScope: LookaheadScope,
) : SharedTransitionScope, LookaheadScope by lookaheadScope {

    override var isTransitionActive: Boolean by mutableStateOf(false)

    override fun Modifier.skipToLookaheadSize(enabled: () -> Boolean): Modifier = this

    override fun Modifier.skipToLookaheadPosition(enabled: () -> Boolean): Modifier = this

    override fun Modifier.renderInSharedTransitionScopeOverlay(
        zIndexInOverlay: Float,
        renderInOverlay: () -> Boolean,
    ): Modifier = this

    override fun Modifier.sharedElement(
        sharedContentState: SharedTransitionScope.SharedContentState,
        animatedVisibilityScope: AnimatedVisibilityScope,
        boundsTransform: BoundsTransform,
        placeholderSize: PlaceholderSize,
        renderInOverlayDuringTransition: Boolean,
        zIndexInOverlay: Float,
        clipInOverlayDuringTransition: OverlayClip,
    ): Modifier = this

    override fun Modifier.sharedBounds(
        sharedContentState: SharedTransitionScope.SharedContentState,
        animatedVisibilityScope: AnimatedVisibilityScope,
        enter: EnterTransition,
        exit: ExitTransition,
        boundsTransform: BoundsTransform,
        resizeMode: SharedTransitionScope.ResizeMode,
        placeholderSize: PlaceholderSize,
        renderInOverlayDuringTransition: Boolean,
        zIndexInOverlay: Float,
        clipInOverlayDuringTransition: OverlayClip,
    ): Modifier = this

    override fun Modifier.sharedElementWithCallerManagedVisibility(
        sharedContentState: SharedTransitionScope.SharedContentState,
        visible: Boolean,
        boundsTransform: BoundsTransform,
        placeholderSize: PlaceholderSize,
        renderInOverlayDuringTransition: Boolean,
        zIndexInOverlay: Float,
        clipInOverlayDuringTransition: OverlayClip,
    ): Modifier = this

    override fun OverlayClip(clipShape: Shape) = object : OverlayClip {
        override fun getClipPath(
            sharedContentState: SharedTransitionScope.SharedContentState,
            bounds: Rect,
            layoutDirection: LayoutDirection,
            density: Density,
        ): Path? = null
    }

}
