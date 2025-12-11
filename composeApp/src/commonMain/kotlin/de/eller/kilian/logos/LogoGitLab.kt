package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoGitLab: ImageVector
    get() {
        if (_LogoGitLab != null) {
            return _LogoGitLab!!
        }
        _LogoGitLab = ImageVector.Builder(
            name = "LogoGitLab",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFE24329))) {
                moveTo(23.6f, 9.59f)
                lineToRelative(-0.03f, -0.09f)
                lineTo(20.3f, 0.98f)
                curveToRelative(-0.07f, -0.17f, -0.18f, -0.31f, -0.34f, -0.4f)
                curveToRelative(-0.15f, -0.1f, -0.33f, -0.14f, -0.51f, -0.13f)
                curveToRelative(-0.18f, 0f, -0.35f, 0.08f, -0.49f, 0.19f)
                curveToRelative(-0.14f, 0.11f, -0.24f, 0.27f, -0.29f, 0.44f)
                lineToRelative(-2.21f, 6.75f)
                horizontalLineTo(7.54f)
                lineTo(5.34f, 1.07f)
                curveToRelative(-0.05f, -0.17f, -0.15f, -0.33f, -0.29f, -0.44f)
                curveToRelative(-0.14f, -0.11f, -0.31f, -0.18f, -0.49f, -0.19f)
                curveToRelative(-0.18f, 0f, -0.36f, 0.04f, -0.51f, 0.13f)
                curveToRelative(-0.15f, 0.1f, -0.27f, 0.24f, -0.34f, 0.4f)
                lineTo(0.44f, 9.51f)
                lineToRelative(-0.03f, 0.09f)
                curveToRelative(-0.97f, 2.53f, -0.14f, 5.38f, 2.01f, 7.01f)
                curveToRelative(0f, 0f, 0f, 0f, 0.01f, 0f)
                lineToRelative(0.03f, 0.02f)
                lineToRelative(4.98f, 3.73f)
                lineToRelative(2.46f, 1.86f)
                lineToRelative(1.5f, 1.13f)
                curveToRelative(0.36f, 0.27f, 0.86f, 0.27f, 1.22f, 0f)
                lineToRelative(1.5f, -1.13f)
                lineToRelative(2.46f, -1.86f)
                lineToRelative(5.01f, -3.75f)
                reflectiveCurveToRelative(0f, 0f, 0.01f, -0.01f)
                curveToRelative(2.15f, -1.63f, 2.98f, -4.48f, 2.01f, -7.01f)
                horizontalLineToRelative(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFC6D26))) {
                moveTo(23.6f, 9.59f)
                lineToRelative(-0.03f, -0.09f)
                curveToRelative(-1.62f, 0.33f, -3.11f, 1.02f, -4.39f, 1.97f)
                curveToRelative(-0.02f, 0.02f, -3.88f, 2.94f, -7.17f, 5.42f)
                curveToRelative(2.44f, 1.85f, 4.57f, 3.45f, 4.57f, 3.45f)
                lineToRelative(5.01f, -3.75f)
                reflectiveCurveToRelative(0f, 0f, 0.01f, -0.01f)
                curveToRelative(2.15f, -1.63f, 2.98f, -4.48f, 2.01f, -7.01f)
                horizontalLineToRelative(0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFCA326))) {
                moveTo(7.44f, 20.36f)
                lineToRelative(2.46f, 1.86f)
                lineToRelative(1.5f, 1.13f)
                curveToRelative(0.36f, 0.27f, 0.86f, 0.27f, 1.22f, 0f)
                lineToRelative(1.5f, -1.13f)
                lineToRelative(2.46f, -1.86f)
                reflectiveCurveToRelative(-2.13f, -1.61f, -4.57f, -3.45f)
                curveToRelative(-2.44f, 1.85f, -4.57f, 3.45f, -4.57f, 3.45f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFC6D26))) {
                moveTo(4.83f, 11.48f)
                curveToRelative(-1.28f, -0.96f, -2.77f, -1.64f, -4.39f, -1.97f)
                lineToRelative(-0.03f, 0.09f)
                curveToRelative(-0.97f, 2.53f, -0.14f, 5.38f, 2.01f, 7.01f)
                curveToRelative(0f, 0f, 0f, 0f, 0.01f, 0f)
                lineToRelative(0.03f, 0.02f)
                lineToRelative(4.98f, 3.73f)
                reflectiveCurveToRelative(2.13f, -1.61f, 4.57f, -3.45f)
                curveToRelative(-3.29f, -2.49f, -7.15f, -5.41f, -7.17f, -5.42f)
                close()
            }
        }.build()

        return _LogoGitLab!!
    }

@Suppress("ObjectPropertyName")
private var _LogoGitLab: ImageVector? = null
