package de.eller.kilian.logos

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoSQLite: ImageVector
    get() {
        if (_LogoSQLite != null) {
            return _LogoSQLite!!
        }
        _LogoSQLite = ImageVector.Builder(
            name = "LogoSQLite",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF0F80CC))) {
                moveTo(18.17f, 1.06f)
                horizontalLineTo(3.11f)
                curveToRelative(-1.01f, 0f, -1.84f, 0.83f, -1.84f, 1.84f)
                verticalLineToRelative(16.61f)
                curveToRelative(0f, 1.01f, 0.83f, 1.84f, 1.84f, 1.84f)
                horizontalLineToRelative(9.92f)
                curveToRelative(-0.11f, -4.94f, 1.57f, -14.51f, 5.14f, -20.28f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF97D9F6),
                        0.92f to Color(0xFF0F80CC),
                        1f to Color(0xFF0F80CC)
                    ),
                    start = Offset(9.815f, 1.9f),
                    end = Offset(9.815f, 17.296f)
                )
            ) {
                moveTo(17.62f, 1.6f)
                horizontalLineTo(3.11f)
                curveToRelative(-0.72f, 0f, -1.3f, 0.58f, -1.3f, 1.3f)
                verticalLineToRelative(15.4f)
                curveToRelative(3.29f, -1.26f, 8.22f, -2.35f, 11.63f, -2.3f)
                curveToRelative(0.69f, -3.58f, 2.7f, -10.61f, 4.18f, -14.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF003B57))) {
                moveTo(21.68f, 0.52f)
                curveToRelative(-1.03f, -0.92f, -2.28f, -0.55f, -3.51f, 0.54f)
                curveToRelative(-0.18f, 0.16f, -0.37f, 0.34f, -0.55f, 0.54f)
                curveToRelative(-2.11f, 2.24f, -4.07f, 6.38f, -4.67f, 9.54f)
                curveToRelative(0.24f, 0.48f, 0.42f, 1.09f, 0.54f, 1.56f)
                curveToRelative(0.03f, 0.12f, 0.06f, 0.23f, 0.08f, 0.33f)
                curveToRelative(0.05f, 0.23f, 0.08f, 0.37f, 0.08f, 0.37f)
                curveToRelative(0f, 0f, -0.02f, -0.07f, -0.1f, -0.3f)
                curveToRelative(-0.01f, -0.04f, -0.03f, -0.09f, -0.05f, -0.15f)
                curveToRelative(0f, -0.02f, -0.02f, -0.05f, -0.03f, -0.08f)
                curveToRelative(-0.14f, -0.32f, -0.52f, -0.99f, -0.69f, -1.29f)
                curveToRelative(-0.14f, 0.42f, -0.27f, 0.82f, -0.38f, 1.18f)
                curveToRelative(0.48f, 0.88f, 0.78f, 2.4f, 0.78f, 2.4f)
                curveToRelative(0f, 0f, -0.03f, -0.1f, -0.15f, -0.44f)
                curveToRelative(-0.11f, -0.3f, -0.64f, -1.24f, -0.77f, -1.46f)
                curveToRelative(-0.22f, 0.8f, -0.3f, 1.35f, -0.23f, 1.48f)
                curveToRelative(0.15f, 0.26f, 0.3f, 0.7f, 0.42f, 1.19f)
                curveToRelative(0.29f, 1.1f, 0.48f, 2.44f, 0.48f, 2.44f)
                curveToRelative(0f, 0f, 0f, 0.09f, 0.02f, 0.23f)
                curveToRelative(-0.04f, 0.92f, -0.02f, 1.88f, 0.06f, 2.75f)
                curveToRelative(0.09f, 1.15f, 0.27f, 2.13f, 0.5f, 2.66f)
                lineToRelative(0.15f, -0.08f)
                curveToRelative(-0.33f, -1.04f, -0.47f, -2.4f, -0.41f, -3.97f)
                curveToRelative(0.09f, -2.4f, 0.64f, -5.29f, 1.66f, -8.3f)
                curveToRelative(1.72f, -4.55f, 4.11f, -8.2f, 6.3f, -9.94f)
                curveToRelative(-1.99f, 1.8f, -4.69f, 7.63f, -5.5f, 9.79f)
                curveToRelative(-0.9f, 2.42f, -1.55f, 4.68f, -1.93f, 6.86f)
                curveToRelative(0.67f, -2.04f, 2.82f, -2.91f, 2.82f, -2.91f)
                curveToRelative(0f, 0f, 1.06f, -1.3f, 2.29f, -3.17f)
                curveToRelative(-0.74f, 0.17f, -1.95f, 0.46f, -2.36f, 0.63f)
                curveToRelative(-0.6f, 0.25f, -0.76f, 0.34f, -0.76f, 0.34f)
                curveToRelative(0f, 0f, 1.94f, -1.18f, 3.61f, -1.72f)
                curveToRelative(2.29f, -3.61f, 4.79f, -8.75f, 2.28f, -10.99f)
            }
        }.build()

        return _LogoSQLite!!
    }

@Suppress("ObjectPropertyName")
private var _LogoSQLite: ImageVector? = null
