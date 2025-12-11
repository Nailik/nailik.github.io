package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoGitHub: ImageVector
    get() {
        if (_LogoGitHub != null) {
            return _LogoGitHub!!
        }
        _LogoGitHub = ImageVector.Builder(
            name = "LogoGitHub",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(0.56f, 12.52f)
                arcToRelative(
                    11.44f,
                    11.48f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    22.88f,
                    0f
                )
                arcToRelative(
                    11.44f,
                    11.48f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -22.88f,
                    0f
                )
                close()
            }
            path(
                fill = SolidColor(Color(0xFF24292F)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(12.01f, 0f)
                curveTo(5.4f, 0f, 0.05f, 5.37f, 0.05f, 12.01f)
                curveToRelative(0f, 5.31f, 3.43f, 9.8f, 8.18f, 11.39f)
                curveToRelative(0.59f, 0.12f, 0.81f, -0.26f, 0.81f, -0.58f)
                curveToRelative(0f, -0.28f, -0.02f, -1.23f, -0.02f, -2.23f)
                curveToRelative(-3.33f, 0.72f, -4.02f, -1.43f, -4.02f, -1.43f)
                curveToRelative(-0.53f, -1.39f, -1.33f, -1.75f, -1.33f, -1.75f)
                curveToRelative(-1.09f, -0.74f, 0.08f, -0.74f, 0.08f, -0.74f)
                curveToRelative(1.21f, 0.08f, 1.84f, 1.23f, 1.84f, 1.23f)
                curveToRelative(1.07f, 1.83f, 2.79f, 1.31f, 3.49f, 0.99f)
                curveToRelative(0.1f, -0.78f, 0.42f, -1.31f, 0.75f, -1.61f)
                curveToRelative(-2.65f, -0.28f, -5.45f, -1.31f, -5.45f, -5.92f)
                curveToRelative(0f, -1.31f, 0.48f, -2.39f, 1.23f, -3.22f)
                curveToRelative(-0.12f, -0.3f, -0.53f, -1.53f, 0.12f, -3.18f)
                curveToRelative(0f, 0f, 1.01f, -0.32f, 3.29f, 1.23f)
                curveToRelative(0.98f, -0.26f, 1.98f, -0.4f, 2.99f, -0.4f)
                curveToRelative(1.01f, 0f, 2.04f, 0.14f, 2.99f, 0.4f)
                curveToRelative(2.28f, -1.55f, 3.29f, -1.23f, 3.29f, -1.23f)
                curveToRelative(0.65f, 1.65f, 0.24f, 2.88f, 0.12f, 3.18f)
                curveToRelative(0.77f, 0.83f, 1.23f, 1.91f, 1.23f, 3.22f)
                curveToRelative(0f, 4.61f, -2.79f, 5.62f, -5.47f, 5.92f)
                curveToRelative(0.44f, 0.38f, 0.81f, 1.09f, 0.81f, 2.23f)
                curveToRelative(0f, 1.61f, -0.02f, 2.9f, -0.02f, 3.3f)
                curveToRelative(0f, 0.32f, 0.22f, 0.7f, 0.81f, 0.58f)
                curveToRelative(4.75f, -1.59f, 8.18f, -6.08f, 8.18f, -11.39f)
                curveToRelative(0.02f, -6.64f, -5.35f, -12.01f, -11.95f, -12.01f)
                close()
            }
        }.build()

        return _LogoGitHub!!
    }

@Suppress("ObjectPropertyName")
private var _LogoGitHub: ImageVector? = null
