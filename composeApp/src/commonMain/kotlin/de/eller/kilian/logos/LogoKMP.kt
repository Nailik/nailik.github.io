package de.eller.kilian.logos

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoKMP: ImageVector
    get() {
        if (_LogoKMP != null) {
            return _LogoKMP!!
        }
        _LogoKMP = ImageVector.Builder(
            name = "LogoKMP",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF37BCFD),
                        0.58f to Color(0xFF7F52FF),
                        1f to Color(0xFFC711E1)
                    ),
                    center = Offset(21.989f, 2.22f),
                    radius = 30.76f
                )
            ) {
                moveTo(0f, 11.28f)
                verticalLineTo(0.04f)
                lineToRelative(11.24f, 11.24f)
                horizontalLineTo(0f)
                close()
                moveTo(0f, 12.72f)
                verticalLineToRelative(11.28f)
                horizontalLineToRelative(0.03f)
                lineToRelative(11.28f, -11.28f)
                horizontalLineTo(0f)
                close()
                moveTo(13f, 11f)
                lineTo(24f, 0f)
                horizontalLineTo(2f)
                lineToRelative(11f, 11f)
                close()
                moveTo(13.01f, 13.05f)
                lineTo(2.07f, 24f)
                horizontalLineToRelative(21.9f)
                lineToRelative(-10.95f, -10.95f)
                close()
            }
        }.build()

        return _LogoKMP!!
    }

@Suppress("ObjectPropertyName")
private var _LogoKMP: ImageVector? = null
