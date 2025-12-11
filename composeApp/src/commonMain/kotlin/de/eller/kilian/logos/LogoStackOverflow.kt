package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoStackOverflow: ImageVector
    get() {
        if (_LogoStackOverflow != null) {
            return _LogoStackOverflow!!
        }
        _LogoStackOverflow = ImageVector.Builder(
            name = "LogoStackOverflow",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFBBBBBB)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(18.95f, 15.47f)
                lineToRelative(2.13f, 0f)
                lineToRelative(0f, 8.53f)
                lineToRelative(-19.19f, 0f)
                lineToRelative(0f, -8.53f)
                lineToRelative(2.14f, 0f)
                lineToRelative(0f, 6.4f)
                lineToRelative(14.92f, 0f)
                lineToRelative(0f, -6.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF58025))) {
                moveTo(6.35f, 14.84f)
                lineToRelative(10.47f, 2.2f)
                lineToRelative(0.44f, -2.09f)
                lineToRelative(-10.47f, -2.2f)
                lineToRelative(-0.44f, 2.09f)
                close()
                moveTo(7.74f, 9.82f)
                lineToRelative(9.7f, 4.52f)
                lineToRelative(0.9f, -1.94f)
                lineToRelative(-9.7f, -4.52f)
                lineToRelative(-0.9f, 1.94f)
                close()
                moveTo(10.42f, 5.06f)
                lineToRelative(8.22f, 6.85f)
                lineToRelative(1.37f, -1.64f)
                lineTo(11.79f, 3.42f)
                lineToRelative(-1.37f, 1.64f)
                close()
                moveTo(15.73f, 0f)
                lineToRelative(-1.72f, 1.28f)
                lineToRelative(6.39f, 8.59f)
                lineToRelative(1.72f, -1.28f)
                lineTo(15.73f, 0f)
                close()
                moveTo(6.16f, 19.74f)
                horizontalLineToRelative(10.66f)
                verticalLineToRelative(-2.13f)
                horizontalLineTo(6.16f)
                verticalLineToRelative(2.13f)
                close()
            }
        }.build()

        return _LogoStackOverflow!!
    }

@Suppress("ObjectPropertyName")
private var _LogoStackOverflow: ImageVector? = null
