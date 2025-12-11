package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoEikona: ImageVector
    get() {
        if (_LogoEikona != null) {
            return _LogoEikona!!
        }
        _LogoEikona = ImageVector.Builder(
            name = "LogoEikona",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF0F283B))) {
                moveTo(11.72f, 3.47f)
                reflectiveCurveToRelative(0.06f, 0f, 0.08f, 0f)
                curveToRelative(0.09f, -0.01f, 0.18f, -0.01f, 0.26f, 0f)
                curveToRelative(0.02f, 0f, 0.05f, -0.01f, 0.07f, 0f)
                curveToRelative(0.72f, -0.01f, 1.41f, 0.29f, 2.04f, 0.62f)
                curveToRelative(2.31f, 1.52f, 4.62f, 3.05f, 6.92f, 4.58f)
                curveToRelative(0.02f, 0.2f, 0.01f, 0.41f, -0.01f, 0.62f)
                curveToRelative(-2.9f, 2f, -5.8f, 4f, -8.71f, 5.99f)
                curveToRelative(-0.02f, 0f, -0.04f, 0f, -0.06f, -0.02f)
                lineToRelative(-1.74f, -1.2f)
                curveToRelative(-0.03f, -0.19f, -0.04f, -0.39f, -0.02f, -0.59f)
                curveToRelative(2.07f, -1.43f, 4.14f, -2.85f, 6.21f, -4.27f)
                lineToRelative(-4.8f, -3.26f)
                curveToRelative(-2.71f, 1.77f, -5.42f, 3.54f, -8.13f, 5.32f)
                curveToRelative(0.4f, 0.29f, 0.85f, 0.59f, 1.28f, 0.87f)
                lineToRelative(6.82f, -4.42f)
                horizontalLineToRelative(0.03f)
                curveToRelative(0.42f, 0.27f, 0.86f, 0.57f, 1.27f, 0.86f)
                curveToRelative(0.14f, 0.09f, 0.28f, 0.19f, 0.4f, 0.3f)
                curveToRelative(0.02f, 0.01f, 0.03f, 0.02f, 0.04f, 0.04f)
                curveToRelative(0f, 0.19f, 0f, 0.39f, 0f, 0.58f)
                curveToRelative(-2.13f, 1.42f, -4.26f, 2.84f, -6.39f, 4.26f)
                lineToRelative(5.05f, 3.56f)
                curveToRelative(3.53f, -2.48f, 7.06f, -4.97f, 10.59f, -7.46f)
                curveToRelative(0.03f, 0f, 0.04f, 0f, 0.07f, 0.01f)
                curveToRelative(0.5f, 0.29f, 0.98f, 0.87f, 1f, 1.44f)
                verticalLineToRelative(0.02f)
                reflectiveCurveToRelative(0f, 0.05f, -0.01f, 0.07f)
                curveToRelative(0f, 0.03f, 0f, 0.07f, 0.01f, 0.11f)
                verticalLineToRelative(0.08f)
                reflectiveCurveToRelative(0f, 0.07f, -0.01f, 0.11f)
                curveToRelative(0f, 0.02f, 0f, 0.05f, 0.01f, 0.07f)
                curveToRelative(0f, 0.01f, 0f, 0.02f, 0f, 0.04f)
                curveToRelative(0f, 0.61f, -0.28f, 1.22f, -0.74f, 1.63f)
                lineToRelative(-8.64f, 6.35f)
                curveToRelative(-0.85f, 0.64f, -1.91f, 0.83f, -2.95f, 0.73f)
                curveToRelative(-0.66f, -0.06f, -1.32f, -0.32f, -1.89f, -0.65f)
                curveToRelative(-1.83f, -1.37f, -3.67f, -2.72f, -5.52f, -4.06f)
                curveToRelative(-1.14f, -0.83f, -2.29f, -1.68f, -3.4f, -2.53f)
                curveTo(0.23f, 12.79f, 0f, 12.24f, 0f, 11.44f)
                curveToRelative(0f, -0.21f, 0.01f, -0.39f, 0.07f, -0.59f)
                curveToRelative(0.16f, -0.6f, 0.58f, -1.07f, 1.08f, -1.42f)
                lineToRelative(8.4f, -5.36f)
                curveToRelative(0.66f, -0.37f, 1.4f, -0.63f, 2.16f, -0.6f)
                close()
            }
        }.build()

        return _LogoEikona!!
    }

@Suppress("ObjectPropertyName")
private var _LogoEikona: ImageVector? = null
