package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoApple: ImageVector
    get() {
        if (_LogoApple != null) {
            return _LogoApple!!
        }
        _LogoApple = ImageVector.Builder(
            name = "LogoApple",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(21.15f, 8.18f)
                curveToRelative(-0.14f, 0.11f, -2.6f, 1.49f, -2.6f, 4.57f)
                curveToRelative(0f, 3.56f, 3.13f, 4.82f, 3.22f, 4.85f)
                curveToRelative(-0.01f, 0.08f, -0.5f, 1.73f, -1.65f, 3.41f)
                curveToRelative(-1.03f, 1.48f, -2.1f, 2.95f, -3.73f, 2.95f)
                reflectiveCurveToRelative(-2.05f, -0.95f, -3.94f, -0.95f)
                reflectiveCurveToRelative(-2.49f, 0.98f, -3.98f, 0.98f)
                reflectiveCurveToRelative(-2.53f, -1.37f, -3.73f, -3.05f)
                curveToRelative(-1.39f, -1.97f, -2.51f, -5.04f, -2.51f, -7.95f)
                curveToRelative(0f, -4.67f, 3.03f, -7.14f, 6.02f, -7.14f)
                curveToRelative(1.59f, 0f, 2.91f, 1.04f, 3.91f, 1.04f)
                reflectiveCurveToRelative(2.43f, -1.1f, 4.23f, -1.1f)
                curveToRelative(0.68f, 0f, 3.14f, 0.06f, 4.76f, 2.38f)
                horizontalLineToRelative(0f)
                close()
                moveTo(15.53f, 3.83f)
                curveToRelative(0.75f, -0.89f, 1.27f, -2.11f, 1.27f, -3.34f)
                curveToRelative(0f, -0.17f, -0.01f, -0.34f, -0.05f, -0.48f)
                curveToRelative(-1.21f, 0.05f, -2.66f, 0.81f, -3.53f, 1.82f)
                curveToRelative(-0.68f, 0.78f, -1.32f, 2.01f, -1.32f, 3.25f)
                curveToRelative(0f, 0.19f, 0.03f, 0.37f, 0.05f, 0.43f)
                curveToRelative(0.08f, 0.01f, 0.2f, 0.03f, 0.33f, 0.03f)
                curveToRelative(1.09f, 0f, 2.46f, -0.73f, 3.25f, -1.71f)
                horizontalLineToRelative(0f)
                close()
            }
        }.build()

        return _LogoApple!!
    }

@Suppress("ObjectPropertyName")
private var _LogoApple: ImageVector? = null
