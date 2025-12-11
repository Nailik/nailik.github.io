package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoKoin: ImageVector
    get() {
        if (_LogoKoin != null) {
            return _LogoKoin!!
        }
        _LogoKoin = ImageVector.Builder(
            name = "LogoKoin",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF2F2F2E))) {
                moveTo(11.42f, 0.03f)
                curveToRelative(8.92f, -0.45f, 15.19f, 8.75f, 11.51f, 16.92f)
                curveToRelative(-3.89f, 8.64f, -15.94f, 9.51f, -21.04f, 1.5f)
                curveTo(-3.06f, 10.69f, 2.28f, 0.49f, 11.42f, 0.03f)
                close()
                moveTo(14.04f, 12f)
                lineToRelative(6.34f, -3.85f)
                curveToRelative(-1.8f, -3.93f, -6.1f, -6.05f, -10.34f, -5.13f)
                curveTo(2.78f, 4.6f, 0.36f, 13.83f, 5.9f, 18.82f)
                curveToRelative(4.59f, 4.13f, 11.93f, 2.57f, 14.48f, -3f)
                verticalLineToRelative(-0.11f)
                reflectiveCurveToRelative(-6.34f, -3.7f, -6.34f, -3.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF8B133))) {
                moveTo(18.45f, 7.71f)
                lineToRelative(-7.24f, 4.27f)
                lineToRelative(7.22f, 4.27f)
                curveToRelative(-1.88f, 2.97f, -5.76f, 4.2f, -9.06f, 2.98f)
                curveToRelative(-2.44f, -0.9f, -4.35f, -3.04f, -4.89f, -5.6f)
                curveTo(3.25f, 7.89f, 8.54f, 2.94f, 14.19f, 4.56f)
                curveToRelative(1.71f, 0.49f, 3.32f, 1.65f, 4.26f, 3.15f)
                close()
            }
        }.build()

        return _LogoKoin!!
    }

@Suppress("ObjectPropertyName")
private var _LogoKoin: ImageVector? = null
