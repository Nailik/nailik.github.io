package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoHomeAssistant: ImageVector
    get() {
        if (_LogoHomeAssistant != null) {
            return _LogoHomeAssistant!!
        }
        _LogoHomeAssistant = ImageVector.Builder(
            name = "LogoHomeAssistant",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFF2F4F9))) {
                moveTo(24f, 22.19f)
                curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f)
                horizontalLineTo(1.5f)
                curveTo(0.68f, 23.69f, 0f, 23.01f, 0f, 22.19f)
                verticalLineToRelative(-9f)
                curveToRelative(0f, -0.82f, 0.48f, -1.98f, 1.06f, -2.56f)
                lineTo(10.94f, 0.75f)
                curveToRelative(0.58f, -0.58f, 1.54f, -0.58f, 2.12f, 0f)
                lineToRelative(9.88f, 9.88f)
                curveToRelative(0.58f, 0.58f, 1.06f, 1.74f, 1.06f, 2.56f)
                verticalLineToRelative(9f)
                horizontalLineToRelative(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF18BCF2))) {
                moveTo(22.94f, 10.63f)
                lineTo(13.07f, 0.75f)
                curveToRelative(-0.58f, -0.58f, -1.54f, -0.58f, -2.12f, 0f)
                lineTo(1.07f, 10.63f)
                curveTo(0.48f, 11.21f, 0f, 12.36f, 0f, 13.19f)
                verticalLineToRelative(9f)
                curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
                horizontalLineToRelative(9.23f)
                lineToRelative(-4.06f, -4.06f)
                curveToRelative(-0.21f, 0.07f, -0.43f, 0.11f, -0.66f, 0.11f)
                curveToRelative(-1.13f, 0f, -2.05f, -0.92f, -2.05f, -2.05f)
                reflectiveCurveToRelative(0.92f, -2.05f, 2.05f, -2.05f)
                reflectiveCurveToRelative(2.05f, 0.92f, 2.05f, 2.05f)
                curveToRelative(0f, 0.23f, -0.04f, 0.46f, -0.11f, 0.67f)
                lineToRelative(3.16f, 3.16f)
                verticalLineToRelative(-11.59f)
                curveToRelative(-0.68f, -0.33f, -1.15f, -1.03f, -1.15f, -1.84f)
                curveToRelative(0f, -1.13f, 0.92f, -2.05f, 2.05f, -2.05f)
                reflectiveCurveToRelative(2.05f, 0.92f, 2.05f, 2.05f)
                curveToRelative(0f, 0.81f, -0.47f, 1.51f, -1.15f, 1.84f)
                verticalLineToRelative(8.13f)
                lineToRelative(3.15f, -3.15f)
                curveToRelative(-0.06f, -0.2f, -0.1f, -0.4f, -0.1f, -0.62f)
                curveToRelative(0f, -1.13f, 0.92f, -2.05f, 2.05f, -2.05f)
                reflectiveCurveToRelative(2.05f, 0.92f, 2.05f, 2.05f)
                reflectiveCurveToRelative(-0.92f, 2.05f, -2.05f, 2.05f)
                curveToRelative(-0.25f, 0f, -0.49f, -0.05f, -0.71f, -0.13f)
                lineToRelative(-4.39f, 4.39f)
                verticalLineToRelative(3.09f)
                horizontalLineToRelative(9.6f)
                curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f)
                verticalLineToRelative(-9f)
                curveToRelative(0f, -0.83f, -0.48f, -1.98f, -1.06f, -2.56f)
                horizontalLineToRelative(0f)
                close()
            }
        }.build()

        return _LogoHomeAssistant!!
    }

@Suppress("ObjectPropertyName")
private var _LogoHomeAssistant: ImageVector? = null
