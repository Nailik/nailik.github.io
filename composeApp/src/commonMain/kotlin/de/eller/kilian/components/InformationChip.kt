package de.eller.kilian.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.IntrinsicMeasurable
import androidx.compose.ui.layout.IntrinsicMeasureScope
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.util.fastFirst
import androidx.compose.ui.util.fastFirstOrNull
import androidx.compose.ui.util.fastMaxOfOrNull
import androidx.compose.ui.util.fastSumBy

/**
 * Forked Chip from Material that is not clickable
 */
@Composable
fun InformationChip(
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = AssistChipDefaults.shape,
    border: BorderStroke? = AssistChipDefaults.assistChipBorder(true),
    colors: ChipColors = AssistChipDefaults.assistChipColors(),
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = colors.containerColor,
        shadowElevation = 0.dp,
        border = border,
    ) {
        ChipContent(
            label = label,
            labelTextStyle = MaterialTheme.typography.labelLarge,
            labelColor = colors.labelColor,
            leadingIcon = leadingIcon,
            avatar = null,
            trailingIcon = trailingIcon,
            leadingIconColor = colors.leadingIconContentColor,
            trailingIconColor = colors.trailingIconContentColor,
            minHeight = 32.dp,
            paddingValues = PaddingValues(horizontal = 8.dp),
        )
    }
}

private const val LeadingIconLayoutId = "leadingIcon"
private const val LabelLayoutId = "label"
private const val TrailingIconLayoutId = "trailingIcon"

@Composable
private fun ChipContent(
    label: @Composable () -> Unit,
    labelTextStyle: TextStyle,
    labelColor: Color,
    leadingIcon: @Composable (() -> Unit)?,
    avatar: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    leadingIconColor: Color,
    trailingIconColor: Color,
    minHeight: Dp,
    paddingValues: PaddingValues,
) {
    CompositionLocalProvider(
        LocalContentColor provides labelColor,
        LocalTextStyle provides labelTextStyle,
    ) {
        Layout(
            modifier = Modifier.defaultMinSize(minHeight = minHeight).padding(paddingValues),
            content = {
                if (avatar != null || leadingIcon != null) {
                    Box(
                        modifier = Modifier.layoutId(LeadingIconLayoutId),
                        contentAlignment = Alignment.Center,
                        content = {
                            val leadingContent =
                                leadingContent(avatar, leadingIcon, leadingIconColor)
                            if (leadingContent != null) {
                                leadingContent()
                            }
                        },
                    )
                }
                Row(
                    modifier =
                        Modifier.layoutId(LabelLayoutId).padding(8.dp, 0.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    content = { label() },
                )
                if (trailingIcon != null) {
                    Box(
                        modifier = Modifier.layoutId(TrailingIconLayoutId),
                        contentAlignment = Alignment.Center,
                        content = {
                            val trailingContent = trailingContent(trailingIcon, trailingIconColor)
                            if (trailingContent != null) {
                                trailingContent()
                            }
                        },
                    )
                }
            },
            measurePolicy = remember { ChipLayoutMeasurePolicy() },
        )
    }
}

@Composable
private fun leadingContent(
    avatar: @Composable (() -> Unit)?,
    leadingIcon: @Composable (() -> Unit)?,
    leadingIconColor: Color,
): @Composable (() -> Unit)? =
    when {
        avatar != null -> avatar // An avatar takes precedence
        leadingIcon != null -> {
            @Composable {
                CompositionLocalProvider(
                    LocalContentColor provides leadingIconColor,
                    content = leadingIcon,
                )
            }
        }

        else -> null // Neither exists
    }

@Composable
private fun trailingContent(
    trailingIcon: @Composable (() -> Unit)?,
    trailingIconColor: Color,
): @Composable (() -> Unit)? =
    if (trailingIcon != null) {
        @Composable {
            CompositionLocalProvider(
                LocalContentColor provides trailingIconColor,
                content = trailingIcon,
            )
        }
    } else {
        null
    }

private class ChipLayoutMeasurePolicy : MeasurePolicy {
    override fun MeasureScope.measure(
        measurables: List<Measurable>,
        constraints: Constraints,
    ): MeasureResult {
        val leadingIconPlaceable: Placeable? =
            measurables
                .fastFirstOrNull { it.layoutId == LeadingIconLayoutId }
                ?.measure(constraints.copy(minWidth = 0, minHeight = 0))
        val leadingIconWidth = leadingIconPlaceable.widthOrZero
        val leadingIconHeight = leadingIconPlaceable.heightOrZero

        val trailingIconPlaceable: Placeable? =
            measurables
                .fastFirstOrNull { it.layoutId == TrailingIconLayoutId }
                ?.measure(constraints.copy(minWidth = 0, minHeight = 0))
        val trailingIconWidth = trailingIconPlaceable.widthOrZero
        val trailingIconHeight = trailingIconPlaceable.heightOrZero

        val labelPlaceable =
            measurables
                .fastFirst { it.layoutId == LabelLayoutId }
                .measure(constraints.offset(horizontal = -(leadingIconWidth + trailingIconWidth)))

        val width = leadingIconWidth + labelPlaceable.width + trailingIconWidth
        val height = maxOf(leadingIconHeight, labelPlaceable.height, trailingIconHeight)

        return layout(width, height) {
            leadingIconPlaceable?.placeRelative(
                0,
                Alignment.CenterVertically.align(leadingIconHeight, height),
            )
            labelPlaceable.placeRelative(leadingIconWidth, 0)
            trailingIconPlaceable?.placeRelative(
                leadingIconWidth + labelPlaceable.width,
                Alignment.CenterVertically.align(trailingIconHeight, height),
            )
        }
    }

    override fun IntrinsicMeasureScope.minIntrinsicHeight(
        measurables: List<IntrinsicMeasurable>,
        width: Int,
    ): Int = measurables.fastMaxOfOrNull { it.minIntrinsicHeight(width) } ?: 0

    override fun IntrinsicMeasureScope.maxIntrinsicHeight(
        measurables: List<IntrinsicMeasurable>,
        width: Int,
    ): Int = measurables.fastMaxOfOrNull { it.maxIntrinsicHeight(width) } ?: 0

    override fun IntrinsicMeasureScope.minIntrinsicWidth(
        measurables: List<IntrinsicMeasurable>,
        height: Int,
    ): Int = measurables.fastSumBy { it.minIntrinsicWidth(height) }

    override fun IntrinsicMeasureScope.maxIntrinsicWidth(
        measurables: List<IntrinsicMeasurable>,
        height: Int,
    ): Int = measurables.fastSumBy { it.maxIntrinsicWidth(height) }
}

internal val Placeable?.widthOrZero: Int
    get() = this?.width ?: 0

internal val Placeable?.heightOrZero: Int
    get() = this?.height ?: 0