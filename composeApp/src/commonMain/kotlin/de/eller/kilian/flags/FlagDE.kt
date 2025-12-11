package de.eller.kilian.flags

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Flags.FlagDE: ImageVector
    get() {
        if (_FlagDE != null) {
            return _FlagDE!!
        }
        _FlagDE = ImageVector.Builder(
            name = "FlagDE",
            defaultWidth = 1000.dp,
            defaultHeight = 600.dp,
            viewportWidth = 5f,
            viewportHeight = 3f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(0f, 0f)
                horizontalLineToRelative(5f)
                verticalLineToRelative(3f)
                horizontalLineToRelative(-5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDD0000))) {
                moveTo(0f, 1f)
                horizontalLineToRelative(5f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(-5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFCE00))) {
                moveTo(0f, 2f)
                horizontalLineToRelative(5f)
                verticalLineToRelative(1f)
                horizontalLineToRelative(-5f)
                close()
            }
        }.build()

        return _FlagDE!!
    }

@Suppress("ObjectPropertyName")
private var _FlagDE: ImageVector? = null
