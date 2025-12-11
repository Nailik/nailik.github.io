package de.eller.kilian.flags

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Flags.FlagEN: ImageVector
    get() {
        if (_FlagEN != null) {
            return _FlagEN!!
        }
        _FlagEN = ImageVector.Builder(
            name = "FlagEN",
            defaultWidth = 1200.dp,
            defaultHeight = 600.dp,
            viewportWidth = 60f,
            viewportHeight = 30f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    verticalLineToRelative(30f)
                    horizontalLineToRelative(60f)
                    verticalLineToRelative(-30f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFF012169))) {
                    moveTo(0f, 0f)
                    verticalLineToRelative(30f)
                    horizontalLineToRelative(60f)
                    verticalLineToRelative(-30f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color.White),
                    strokeLineWidth = 6f
                ) {
                    moveTo(0f, 0f)
                    lineTo(60f, 30f)
                    moveTo(60f, 0f)
                    lineTo(0f, 30f)
                }
            }
            group(
                clipPathData = PathData {
                    moveTo(30f, 15f)
                    horizontalLineToRelative(30f)
                    verticalLineToRelative(15f)
                    close()
                    verticalLineToRelative(15f)
                    horizontalLineToRelative(-30f)
                    close()
                    horizontalLineToRelative(-30f)
                    verticalLineToRelative(-15f)
                    close()
                    verticalLineToRelative(-15f)
                    horizontalLineToRelative(30f)
                    close()
                }
            ) {
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color(0xFFC8102E)),
                    strokeLineWidth = 4f
                ) {
                    moveTo(0f, 0f)
                    lineTo(60f, 30f)
                    moveTo(60f, 0f)
                    lineTo(0f, 30f)
                }
            }
            path(
                fill = SolidColor(Color.Black),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 10f
            ) {
                moveTo(30f, 0f)
                verticalLineToRelative(30f)
                moveTo(0f, 15f)
                horizontalLineToRelative(60f)
            }
            path(
                fill = SolidColor(Color.Black),
                stroke = SolidColor(Color(0xFFC8102E)),
                strokeLineWidth = 6f
            ) {
                moveTo(30f, 0f)
                verticalLineToRelative(30f)
                moveTo(0f, 15f)
                horizontalLineToRelative(60f)
            }
        }.build()

        return _FlagEN!!
    }

@Suppress("ObjectPropertyName")
private var _FlagEN: ImageVector? = null
