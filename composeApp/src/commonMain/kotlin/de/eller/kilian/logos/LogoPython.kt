package de.eller.kilian.logos

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoPython: ImageVector
    get() {
        if (_LogoPython != null) {
            return _LogoPython!!
        }
        _LogoPython = ImageVector.Builder(
            name = "LogoPython",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF366A96),
                        1f to Color(0xFF3679B0)
                    ),
                    start = Offset(17.763f, 8.924f),
                    end = Offset(0.02f, 8.782f)
                )
            ) {
                moveTo(6.21f, 3.21f)
                curveToRelative(0f, -1.65f, 0.44f, -2.55f, 2.89f, -2.98f)
                curveTo(10.76f, -0.06f, 12.89f, -0.1f, 14.87f, 0.23f)
                curveToRelative(1.57f, 0.26f, 2.89f, 1.43f, 2.89f, 2.98f)
                verticalLineToRelative(5.45f)
                curveToRelative(0f, 1.6f, -1.28f, 2.91f, -2.89f, 2.91f)
                horizontalLineToRelative(-5.78f)
                curveToRelative(-1.96f, 0f, -3.61f, 1.67f, -3.61f, 3.56f)
                verticalLineToRelative(2.62f)
                horizontalLineToRelative(-1.99f)
                curveToRelative(-1.68f, 0f, -2.66f, -1.21f, -3.07f, -2.91f)
                curveTo(-0.12f, 12.56f, -0.1f, 11.21f, 0.43f, 9.03f)
                curveToRelative(0.46f, -1.9f, 1.93f, -2.91f, 3.61f, -2.91f)
                horizontalLineToRelative(7.95f)
                verticalLineToRelative(-0.73f)
                horizontalLineToRelative(-5.78f)
                verticalLineToRelative(-2.18f)
                horizontalLineToRelative(0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFC836),
                        1f to Color(0xFFFFE873)
                    ),
                    start = Offset(23.986f, 15.029f),
                    end = Offset(-11.131f, 15.029f)
                )
            ) {
                moveTo(17.76f, 20.66f)
                curveToRelative(0f, 1.65f, -1.43f, 2.49f, -2.89f, 2.91f)
                curveToRelative(-2.19f, 0.63f, -3.95f, 0.53f, -5.78f, 0f)
                curveToRelative(-1.53f, -0.45f, -2.89f, -1.35f, -2.89f, -2.91f)
                verticalLineToRelative(-5.45f)
                curveToRelative(0f, -1.57f, 1.31f, -2.91f, 2.89f, -2.91f)
                horizontalLineToRelative(5.78f)
                curveToRelative(1.92f, 0f, 3.61f, -1.66f, 3.61f, -3.63f)
                verticalLineToRelative(-2.54f)
                horizontalLineToRelative(2.17f)
                curveToRelative(1.68f, 0f, 2.47f, 1.25f, 2.89f, 2.91f)
                curveToRelative(0.58f, 2.3f, 0.6f, 4.02f, 0f, 5.82f)
                curveToRelative(-0.58f, 1.74f, -1.21f, 2.91f, -2.89f, 2.91f)
                horizontalLineToRelative(-8.67f)
                verticalLineToRelative(0.73f)
                horizontalLineToRelative(5.78f)
                verticalLineToRelative(2.18f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(7.65f, 2.85f)
                curveToRelative(0f, -0.6f, 0.48f, -1.09f, 1.08f, -1.09f)
                reflectiveCurveToRelative(1.08f, 0.49f, 1.08f, 1.09f)
                reflectiveCurveToRelative(-0.49f, 1.09f, -1.08f, 1.09f)
                reflectiveCurveToRelative(-1.08f, -0.49f, -1.08f, -1.09f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(14.15f, 21.02f)
                curveToRelative(0f, -0.6f, 0.49f, -1.09f, 1.08f, -1.09f)
                reflectiveCurveToRelative(1.08f, 0.49f, 1.08f, 1.09f)
                reflectiveCurveToRelative(-0.48f, 1.09f, -1.08f, 1.09f)
                reflectiveCurveToRelative(-1.08f, -0.49f, -1.08f, -1.09f)
                close()
            }
        }.build()

        return _LogoPython!!
    }

@Suppress("ObjectPropertyName")
private var _LogoPython: ImageVector? = null
