package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoFirebase: ImageVector
    get() {
        if (_LogoFirebase != null) {
            return _LogoFirebase!!
        }
        _LogoFirebase = ImageVector.Builder(
            name = "LogoFirebase",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFFF9100))) {
                moveTo(8.44f, 23.31f)
                curveToRelative(1f, 0.4f, 2.09f, 0.64f, 3.24f, 0.68f)
                curveToRelative(1.55f, 0.05f, 3.02f, -0.27f, 4.34f, -0.87f)
                curveToRelative(-1.58f, -0.62f, -3.01f, -1.53f, -4.23f, -2.65f)
                curveToRelative(-0.79f, 1.27f, -1.96f, 2.27f, -3.35f, 2.84f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFC400))) {
                moveTo(11.78f, 20.47f)
                curveToRelative(-2.78f, -2.58f, -4.47f, -6.3f, -4.33f, -10.39f)
                curveToRelative(0f, -0.13f, 0.01f, -0.27f, 0.02f, -0.4f)
                curveToRelative(-0.5f, -0.13f, -1.02f, -0.21f, -1.56f, -0.23f)
                curveToRelative(-0.77f, -0.03f, -1.51f, 0.07f, -2.21f, 0.27f)
                curveToRelative(-0.74f, 1.3f, -1.19f, 2.8f, -1.25f, 4.4f)
                curveToRelative(-0.14f, 4.13f, 2.36f, 7.74f, 5.98f, 9.2f)
                curveToRelative(1.39f, -0.58f, 2.56f, -1.58f, 3.35f, -2.84f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF9100))) {
                moveTo(11.78f, 20.47f)
                curveToRelative(0.65f, -1.04f, 1.04f, -2.25f, 1.09f, -3.56f)
                curveToRelative(0.12f, -3.44f, -2.19f, -6.4f, -5.4f, -7.23f)
                curveToRelative(0f, 0.13f, -0.02f, 0.27f, -0.02f, 0.4f)
                curveToRelative(-0.14f, 4.09f, 1.55f, 7.82f, 4.33f, 10.39f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDD2C00))) {
                moveTo(12.51f, 0f)
                curveToRelative(-1.82f, 1.46f, -3.26f, 3.39f, -4.14f, 5.61f)
                curveToRelative(-0.5f, 1.27f, -0.81f, 2.64f, -0.9f, 4.07f)
                curveToRelative(3.2f, 0.83f, 5.52f, 3.79f, 5.4f, 7.23f)
                curveToRelative(-0.05f, 1.31f, -0.44f, 2.52f, -1.09f, 3.56f)
                curveToRelative(1.22f, 1.13f, 2.65f, 2.03f, 4.23f, 2.65f)
                curveToRelative(3.17f, -1.46f, 5.42f, -4.62f, 5.55f, -8.34f)
                curveToRelative(0.08f, -2.41f, -0.84f, -4.57f, -2.15f, -6.38f)
                curveToRelative(-1.38f, -1.92f, -6.89f, -8.4f, -6.89f, -8.4f)
                close()
            }
        }.build()

        return _LogoFirebase!!
    }

@Suppress("ObjectPropertyName")
private var _LogoFirebase: ImageVector? = null
