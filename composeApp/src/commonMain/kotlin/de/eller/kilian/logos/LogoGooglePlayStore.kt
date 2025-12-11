package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoGooglePlayStore: ImageVector
    get() {
        if (_LogoGooglePlayStore != null) {
            return _LogoGooglePlayStore!!
        }
        _LogoGooglePlayStore = ImageVector.Builder(
            name = "LogoGooglePlayStore",
            defaultWidth = 25.54.dp,
            defaultHeight = 24.dp,
            viewportWidth = 25.54f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFEA4335))) {
                moveTo(12.05f, 11.47f)
                lineTo(1.98f, 22.02f)
                curveToRelative(0.42f, 1.46f, 1.95f, 2.3f, 3.4f, 1.87f)
                curveToRelative(0.21f, -0.06f, 0.41f, -0.15f, 0.6f, -0.25f)
                lineToRelative(11.33f, -6.45f)
                lineToRelative(-5.26f, -5.72f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFBBC04))) {
                moveTo(22.24f, 9.67f)
                lineToRelative(-4.9f, -2.81f)
                lineToRelative(-5.52f, 4.84f)
                lineToRelative(5.54f, 5.46f)
                lineToRelative(4.86f, -2.78f)
                curveToRelative(1.3f, -0.68f, 1.81f, -2.28f, 1.13f, -3.58f)
                curveToRelative(0f, 0f, 0f, 0f, 0f, -0.01f)
                curveToRelative(-0.25f, -0.48f, -0.65f, -0.87f, -1.13f, -1.13f)
                horizontalLineToRelative(0.02f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4285F4))) {
                moveTo(1.98f, 2f)
                curveToRelative(-0.06f, 0.23f, -0.09f, 0.46f, -0.09f, 0.69f)
                verticalLineToRelative(18.64f)
                curveToRelative(0f, 0.23f, 0.03f, 0.47f, 0.09f, 0.69f)
                lineToRelative(10.42f, -10.28f)
                lineTo(1.98f, 2f)
                close()
            }
            path(fill = SolidColor(Color(0xFF34A853))) {
                moveTo(12.13f, 12.01f)
                lineToRelative(5.21f, -5.14f)
                lineTo(6.02f, 0.38f)
                curveTo(5.59f, 0.13f, 5.11f, 0f, 4.62f, 0f)
                curveToRelative(-1.22f, 0f, -2.3f, 0.81f, -2.63f, 1.99f)
                lineToRelative(10.15f, 10.02f)
                close()
            }
        }.build()

        return _LogoGooglePlayStore!!
    }

@Suppress("ObjectPropertyName")
private var _LogoGooglePlayStore: ImageVector? = null
