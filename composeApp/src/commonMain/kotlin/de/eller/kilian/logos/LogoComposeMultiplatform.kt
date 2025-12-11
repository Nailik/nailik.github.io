package de.eller.kilian.logos

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoComposeMultiplatform: ImageVector
    get() {
        if (_LogoComposeMultiplatform != null) {
            return _LogoComposeMultiplatform!!
        }
        _LogoComposeMultiplatform = ImageVector.Builder(
            name = "LogoComposeMultiplatform",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF6075F2))) {
                moveTo(22.29f, 6f)
                verticalLineToRelative(12f)
                lineToRelative(-10.29f, 6f)
                lineTo(1.72f, 18f)
                verticalLineTo(6f)
                lineTo(12f, 0f)
                lineToRelative(10.29f, 6f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 7.29f)
                lineToRelative(4.07f, 2.36f)
                verticalLineToRelative(4.71f)
                reflectiveCurveToRelative(-4.07f, 2.36f, -4.07f, 2.36f)
                lineToRelative(-4.07f, -2.36f)
                verticalLineToRelative(-4.71f)
                lineToRelative(4.07f, -2.36f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF33C3FF),
                        0.88f to Color(0xFF5383EC)
                    ),
                    start = Offset(17.19f, 0.13f),
                    end = Offset(5.96f, 12.84f)
                )
            ) {
                moveTo(7.93f, 9.64f)
                lineToRelative(4.07f, -2.36f)
                lineToRelative(4.07f, 2.36f)
                lineToRelative(6.21f, -3.64f)
                lineTo(12f, 0f)
                lineTo(1.72f, 6f)
                lineToRelative(6.21f, 3.64f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF5383EC),
                        0.87f to Color(0xFF7F52FF)
                    ),
                    center = Offset(8.357f, 6.138f),
                    radius = 18.116f
                )
            ) {
                moveTo(12f, 16.71f)
                lineToRelative(-4.07f, -2.36f)
                verticalLineToRelative(-4.71f)
                lineTo(1.72f, 6f)
                verticalLineToRelative(12f)
                lineToRelative(10.29f, 6f)
                verticalLineToRelative(-7.29f)
                close()
            }
            path(fill = SolidColor(Color(0xFF6B57FF))) {
                moveTo(16.08f, 9.64f)
                verticalLineToRelative(4.71f)
                lineToRelative(-4.07f, 2.36f)
                verticalLineToRelative(7.29f)
                lineToRelative(10.29f, -6f)
                verticalLineTo(6f)
                lineToRelative(-6.21f, 3.64f)
                close()
            }
        }.build()

        return _LogoComposeMultiplatform!!
    }

@Suppress("ObjectPropertyName")
private var _LogoComposeMultiplatform: ImageVector? = null
