package de.eller.kilian.logos

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoJira: ImageVector
    get() {
        if (_LogoJira != null) {
            return _LogoJira!!
        }
        _LogoJira = ImageVector.Builder(
            name = "LogoJira",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF2684FF))) {
                moveTo(23.01f, 0f)
                horizontalLineToRelative(-11.55f)
                curveToRelative(0f, 2.88f, 2.33f, 5.21f, 5.21f, 5.21f)
                horizontalLineToRelative(2.12f)
                verticalLineToRelative(2.06f)
                curveToRelative(0f, 2.88f, 2.33f, 5.21f, 5.21f, 5.21f)
                verticalLineTo(0.99f)
                curveTo(24f, 0.45f, 23.56f, 0f, 23.01f, 0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.18f to Color(0xFF0052CC),
                        1f to Color(0xFF2684FF)
                    ),
                    start = Offset(18.03f, 5.78f),
                    end = Offset(13.11f, 10.86f)
                )
            ) {
                moveTo(17.28f, 5.76f)
                horizontalLineTo(5.73f)
                curveToRelative(0f, 2.88f, 2.33f, 5.21f, 5.21f, 5.21f)
                horizontalLineToRelative(2.13f)
                verticalLineToRelative(2.06f)
                curveToRelative(0f, 2.88f, 2.33f, 5.21f, 5.21f, 5.21f)
                verticalLineTo(6.75f)
                curveToRelative(0f, -0.55f, -0.45f, -0.99f, -0.99f, -0.99f)
                horizontalLineToRelative(0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.18f to Color(0xFF0052CC),
                        1f to Color(0xFF2684FF)
                    ),
                    start = Offset(12.67f, 11.58f),
                    end = Offset(6.95f, 17.1f)
                )
            ) {
                moveTo(11.56f, 11.52f)
                horizontalLineTo(0f)
                curveTo(0f, 14.4f, 2.34f, 16.73f, 5.22f, 16.73f)
                horizontalLineToRelative(2.12f)
                verticalLineToRelative(2.06f)
                curveToRelative(0f, 2.88f, 2.33f, 5.21f, 5.21f, 5.21f)
                verticalLineToRelative(-11.49f)
                curveToRelative(0f, -0.55f, -0.45f, -0.99f, -0.99f, -0.99f)
                horizontalLineToRelative(0f)
                close()
            }
        }.build()

        return _LogoJira!!
    }

@Suppress("ObjectPropertyName")
private var _LogoJira: ImageVector? = null
