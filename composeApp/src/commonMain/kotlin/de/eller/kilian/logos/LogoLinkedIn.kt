package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoLinkedIn: ImageVector
    get() {
        if (_LogoLinkedIn != null) {
            return _LogoLinkedIn!!
        }
        _LogoLinkedIn = ImageVector.Builder(
            name = "LogoLinkedIn",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF006699))) {
                moveTo(0.08f, 1.72f)
                curveTo(0.08f, 0.77f, 0.87f, 0f, 1.84f, 0f)
                horizontalLineToRelative(20.32f)
                curveToRelative(0.97f, 0f, 1.76f, 0.77f, 1.76f, 1.72f)
                verticalLineToRelative(20.56f)
                curveToRelative(0f, 0.95f, -0.79f, 1.72f, -1.76f, 1.72f)
                horizontalLineTo(1.84f)
                curveToRelative(-0.97f, 0f, -1.76f, -0.77f, -1.76f, -1.72f)
                verticalLineTo(1.72f)
                close()
            }
            path(
                fill = SolidColor(Color.White),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7.28f, 20.14f)
                verticalLineToRelative(-10.91f)
                horizontalLineToRelative(-3.62f)
                verticalLineToRelative(10.91f)
                horizontalLineToRelative(3.62f)
                close()
                moveTo(5.47f, 7.75f)
                curveToRelative(1.26f, 0f, 2.05f, -0.84f, 2.05f, -1.88f)
                curveToRelative(-0.02f, -1.07f, -0.79f, -1.88f, -2.03f, -1.88f)
                reflectiveCurveToRelative(-2.05f, 0.81f, -2.05f, 1.88f)
                reflectiveCurveToRelative(0.79f, 1.88f, 2f, 1.88f)
                horizontalLineToRelative(0.02f)
                close()
            }
            path(
                fill = SolidColor(Color.White),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(9.29f, 20.14f)
                horizontalLineToRelative(3.62f)
                verticalLineToRelative(-6.09f)
                curveToRelative(0f, -0.33f, 0.02f, -0.65f, 0.12f, -0.88f)
                curveToRelative(0.26f, -0.65f, 0.86f, -1.33f, 1.86f, -1.33f)
                curveToRelative(1.31f, 0f, 1.84f, 1f, 1.84f, 2.47f)
                verticalLineToRelative(5.83f)
                horizontalLineToRelative(3.62f)
                verticalLineToRelative(-6.25f)
                curveToRelative(0f, -3.35f, -1.79f, -4.91f, -4.17f, -4.91f)
                curveToRelative(-1.96f, 0f, -2.81f, 1.09f, -3.29f, 1.84f)
                horizontalLineToRelative(0.02f)
                verticalLineToRelative(-1.58f)
                horizontalLineToRelative(-3.62f)
                curveToRelative(0.05f, 1.02f, 0f, 10.91f, 0f, 10.91f)
                horizontalLineToRelative(0f)
                close()
            }
        }.build()

        return _LogoLinkedIn!!
    }

@Suppress("ObjectPropertyName")
private var _LogoLinkedIn: ImageVector? = null
