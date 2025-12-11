package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoXing: ImageVector
    get() {
        if (_LogoXing != null) {
            return _LogoXing!!
        }
        _LogoXing = ImageVector.Builder(
            name = "LogoXing",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF005A5F))) {
                moveTo(3.65f, 4.74f)
                curveToRelative(-0.21f, 0f, -0.38f, 0.07f, -0.47f, 0.22f)
                curveToRelative(-0.09f, 0.15f, -0.08f, 0.34f, 0.02f, 0.53f)
                lineToRelative(2.34f, 4.05f)
                reflectiveCurveToRelative(0f, 0.01f, 0f, 0.02f)
                lineToRelative(-3.68f, 6.49f)
                curveToRelative(-0.1f, 0.19f, -0.09f, 0.38f, 0f, 0.53f)
                curveToRelative(0.09f, 0.14f, 0.24f, 0.24f, 0.45f, 0.24f)
                horizontalLineToRelative(3.46f)
                curveToRelative(0.52f, 0f, 0.77f, -0.35f, 0.94f, -0.67f)
                curveToRelative(0f, 0f, 3.6f, -6.36f, 3.74f, -6.61f)
                curveToRelative(-0.01f, -0.02f, -2.38f, -4.15f, -2.38f, -4.15f)
                curveToRelative(-0.17f, -0.31f, -0.43f, -0.65f, -0.96f, -0.65f)
                horizontalLineToRelative(-3.46f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD4D600))) {
                moveTo(18.19f, 0f)
                curveToRelative(-0.52f, 0f, -0.74f, 0.33f, -0.93f, 0.66f)
                curveToRelative(0f, 0f, -7.46f, 13.22f, -7.7f, 13.66f)
                curveToRelative(0.01f, 0.02f, 4.92f, 9.02f, 4.92f, 9.02f)
                curveToRelative(0.17f, 0.31f, 0.44f, 0.66f, 0.97f, 0.66f)
                horizontalLineToRelative(3.46f)
                curveToRelative(0.21f, 0f, 0.37f, -0.08f, 0.46f, -0.22f)
                curveToRelative(0.09f, -0.15f, 0.09f, -0.34f, 0f, -0.53f)
                lineToRelative(-4.88f, -8.92f)
                reflectiveCurveToRelative(0f, -0.02f, 0f, -0.02f)
                lineTo(22.14f, 0.76f)
                curveToRelative(0.1f, -0.19f, 0.1f, -0.39f, 0f, -0.53f)
                curveToRelative(-0.09f, -0.14f, -0.25f, -0.22f, -0.46f, -0.22f)
                horizontalLineToRelative(-3.5f)
                close()
            }
        }.build()

        return _LogoXing!!
    }

@Suppress("ObjectPropertyName")
private var _LogoXing: ImageVector? = null
