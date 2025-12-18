package de.eller.kilian.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Favicon: ImageVector
    get() {
        if (_Favicon != null) {
            return _Favicon!!
        }
        _Favicon = ImageVector.Builder(
            name = "Favicon",
            defaultWidth = 40.dp,
            defaultHeight = 40.dp,
            viewportWidth = 40f,
            viewportHeight = 40f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFA192F7),
                        0.8f to Color(0xFFCF94F4)
                    ),
                    start = Offset(40f, 40f),
                    end = Offset(-0f, 0f)
                )
            ) {
                moveTo(4f, 0f)
                lineTo(36f, 0f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 40f, 4f)
                lineTo(40f, 36f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 36f, 40f)
                lineTo(4f, 40f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 36f)
                lineTo(0f, 4f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 0f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(6f, 30f)
                horizontalLineToRelative(15f)
                verticalLineToRelative(2.5f)
                horizontalLineToRelative(-15f)
                close()
            }
        }.build()

        return _Favicon!!
    }

@Suppress("ObjectPropertyName")
private var _Favicon: ImageVector? = null
