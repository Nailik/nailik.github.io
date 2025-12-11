package de.eller.kilian.logos

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoKtor: ImageVector
    get() {
        if (_LogoKtor != null) {
            return _LogoKtor!!
        }
        _LogoKtor = ImageVector.Builder(
            name = "LogoKtor",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7F52FF),
                        0.51f to Color(0xFFC711E1),
                        1f to Color(0xFFFF6D3F)
                    ),
                    start = Offset(6.77f, 6.74f),
                    end = Offset(17.07f, 17.09f)
                )
            ) {
                moveTo(24f, 16f)
                lineToRelative(-8f, 8f)
                lineTo(0f, 8f)
                lineTo(8.01f, 0f)
                lineToRelative(16f, 16f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(16.01f, 8f)
                horizontalLineToRelative(-8f)
                verticalLineToRelative(8f)
                horizontalLineToRelative(8f)
                verticalLineTo(8f)
                close()
            }
        }.build()

        return _LogoKtor!!
    }

@Suppress("ObjectPropertyName")
private var _LogoKtor: ImageVector? = null
