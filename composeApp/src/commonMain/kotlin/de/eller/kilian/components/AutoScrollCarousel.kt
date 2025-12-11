package de.eller.kilian.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * Material3 carousel animated to showcase all images
 *
 * TODO currently no auto animation to to compose material but
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoScrollCarousel(
    modifier: Modifier = Modifier,
    initialImageAnimationContentState: String? = null,
    maxItemWidth: Dp = Dp.Unspecified,
    images: ImmutableList<DrawableResource>,
) {

    /*
        val width = with(LocalDensity.current) { maxItemWidth.toPx() }
        LaunchedEffect(Unit) {
            //return@LaunchedEffect
            coroutineScope.launch {
                delay(1000)
                var direction = 1
                while (true) {
                    carouselState.animateScrollBy(
                        (width * (images.size)) * direction,
                        tween(
                            durationMillis = 1000 * (images.size),
                            easing = LinearEasing
                        )
                    )
                    direction *= -1
                }
                /*var item = images.size
                while (true) {
                    carouselState.animateScrollToItem(
                        item,
                        tween(
                            durationMillis = 1000 * (images.size ),
                            easing = LinearEasing
                        )
                    )
                    item = when (item) {
                        0 -> images.size
                        else -> 0
                    }
                }*/
            }
        }*/

    BoxWithConstraints(
        modifier = Modifier.animateContentSize()
    ) {

        val carouselState = rememberCarouselState { images.size }
        val coroutineScope = rememberCoroutineScope()
        val isClickable = maxWidth < ((maxItemWidth + 16.dp) * images.size + 16.dp)

        HorizontalCenteredHeroCarousel(
            modifier = modifier.padding(horizontal = 16.dp),
            state = carouselState,
            itemSpacing = 16.dp,
            maxItemWidth = maxItemWidth,
        ) { index ->
            WithSharedTransitionScope(
                enabled = index == 0 && initialImageAnimationContentState != null
            ) { animatedContentScope ->
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .maskClip(MaterialTheme.shapes.small)
                        .let {
                            if (isClickable) {
                                it.clickable {
                                    coroutineScope.launch {
                                        carouselState.animateScrollToItem(index)
                                    }
                                }.pointerHoverIcon(PointerIcon.Hand)
                            } else it
                        }
                        .background(MaterialTheme.colorScheme.surfaceContainer)
                        .sharedElement(
                            sharedContentState = rememberSharedContentState(
                                key = initialImageAnimationContentState ?: ""
                            ),
                            animatedVisibilityScope = animatedContentScope,
                        ),
                    painter = painterResource(images[index]),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                )
            }
        }
    }
}