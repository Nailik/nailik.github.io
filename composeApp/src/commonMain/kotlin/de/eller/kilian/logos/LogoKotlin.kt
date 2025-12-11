package de.eller.kilian.logos

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoKotlin: ImageVector
    get() {
        if (_LogoKotlin != null) {
            return _LogoKotlin!!
        }
        _LogoKotlin = ImageVector.Builder(
            name = "LogoKotlin",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE44857),
                        0.5f to Color(0xFFC711E1),
                        1f to Color(0xFF7F52FF)
                    ),
                    center = Offset(24.23f, 0.02f),
                    radius = 24f
                )
            ) {
                moveTo(24f, 24f)
                horizontalLineTo(0f)
                verticalLineTo(0f)
                horizontalLineToRelative(24f)
                lineToRelative(-12.25f, 11.82f)
                lineToRelative(12.25f, 12.18f)
                close()
            }
        }.build()

        return _LogoKotlin!!
    }

@Suppress("ObjectPropertyName")
private var _LogoKotlin: ImageVector? = null
