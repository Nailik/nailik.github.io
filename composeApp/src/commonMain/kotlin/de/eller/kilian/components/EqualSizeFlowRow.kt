package de.eller.kilian.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max

/**
 * displays each element the same height/width as the largest element
 * balances rows
 * centers items vertically
 */
@Composable
fun EqualSizeFlowRow(
    modifier: Modifier = Modifier,
    horizontalSpacing: Dp = 0.dp,
    verticalSpacing: Dp = 0.dp,
    maxExtraWidth: Dp = 48.dp,
    content: @Composable () -> Unit,
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val hSpacingPx = horizontalSpacing.roundToPx()
        val vSpacingPx = verticalSpacing.roundToPx()
        val maxExtraPx = maxExtraWidth.roundToPx()

        // 1. Compute max intrinsic width among all children
        val maxWidth = measurables.maxOf {
            try {
                it.maxIntrinsicWidth(constraints.maxHeight)
            } catch (_: IllegalStateException) {
                //probably out of range exception
                16777215
            }
        }

        val itemCount = measurables.size
        val maxRowCapacity =
            maxOf(1, (constraints.maxWidth + hSpacingPx) / (maxWidth + hSpacingPx))
        val rowCount = ((itemCount + maxRowCapacity - 1) / maxRowCapacity).coerceAtLeast(1)
        val itemsPerRow = (itemCount + rowCount - 1) / rowCount

        // 2. Split into rows
        val rows = measurables.chunked(itemsPerRow)

        // 3. For each row, compute row width and max intrinsic height
        val placeablesRows: List<List<Placeable>> = rows.map { rowMeasurables ->
            val isSingleItemRow = rowMeasurables.size == 1
            val rowWidth = if (isSingleItemRow) {
                minOf(maxWidth + maxExtraPx, constraints.maxWidth)
            } else {
                maxWidth
            }

            // max intrinsic height for the row (dynamic content supported)
            val rowHeight = rowMeasurables.maxOf { it.maxIntrinsicHeight(rowWidth) }

            // measure each child exactly once
            rowMeasurables.map { measurable ->
                measurable.measure(
                    Constraints(
                        minWidth = rowWidth,
                        maxWidth = rowWidth,
                        minHeight = rowHeight,
                        maxHeight = Constraints.Infinity
                    )
                )
            }
        }

        // 4. Compute row heights and total height
        val rowHeights = placeablesRows.map { row -> row.maxOf { it.height } }
        val totalHeight = rowHeights.sum() + max(0, rowHeights.size - 1) * vSpacingPx

        // 5. Layout children
        layout(minOf(constraints.maxWidth, 16777215), totalHeight) {
            var y = 0
            placeablesRows.forEachIndexed { rowIndex, rowPlaceables ->
                val rowHeight = rowHeights[rowIndex]
                val isSingleItemRow = rowPlaceables.size == 1
                val rowContentWidth = if (isSingleItemRow) rowPlaceables[0].width
                else rowPlaceables.size * maxWidth + (rowPlaceables.size - 1) * hSpacingPx
                val xOffset = (constraints.maxWidth - rowContentWidth) / 2

                var x = xOffset
                rowPlaceables.forEach { child ->
                    child.placeRelative(x, y)
                    x += child.width + hSpacingPx
                }
                y += rowHeight + vSpacingPx
            }
        }
    }
}

