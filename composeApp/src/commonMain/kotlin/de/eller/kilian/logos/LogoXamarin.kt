package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoXamarin: ImageVector
    get() {
        if (_LogoXamarin != null) {
            return _LogoXamarin!!
        }
        _LogoXamarin = ImageVector.Builder(
            name = "LogoXamarin",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF3498DB)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(6.93f, 1.29f)
                curveToRelative(-0.65f, 0f, -1.28f, 0.37f, -1.61f, 0.93f)
                lineTo(0.25f, 11.07f)
                curveToRelative(-0.32f, 0.56f, -0.32f, 1.3f, 0f, 1.87f)
                lineToRelative(5.08f, 8.84f)
                curveToRelative(0.33f, 0.56f, 0.96f, 0.93f, 1.61f, 0.93f)
                horizontalLineToRelative(10.15f)
                curveToRelative(0.65f, 0f, 1.28f, -0.37f, 1.61f, -0.93f)
                lineToRelative(5.08f, -8.84f)
                curveToRelative(0.32f, -0.56f, 0.32f, -1.3f, 0f, -1.87f)
                lineToRelative(-5.08f, -8.84f)
                curveToRelative(-0.33f, -0.56f, -0.96f, -0.93f, -1.61f, -0.93f)
                horizontalLineTo(6.93f)
                close()
            }
            path(
                fill = SolidColor(Color.White),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7.02f, 6.47f)
                reflectiveCurveToRelative(0.03f, 0f, 0.04f, 0f)
                horizontalLineToRelative(1.75f)
                curveToRelative(0.08f, 0f, 0.15f, 0.05f, 0.19f, 0.11f)
                lineToRelative(2.97f, 5.31f)
                reflectiveCurveToRelative(0.02f, 0.06f, 0.03f, 0.09f)
                curveToRelative(0f, -0.03f, 0.01f, -0.06f, 0.03f, -0.09f)
                lineToRelative(2.96f, -5.31f)
                curveToRelative(0.04f, -0.07f, 0.12f, -0.11f, 0.2f, -0.11f)
                horizontalLineToRelative(1.75f)
                curveToRelative(0.16f, 0f, 0.27f, 0.2f, 0.2f, 0.33f)
                lineToRelative(-2.9f, 5.2f)
                lineToRelative(2.9f, 5.19f)
                curveToRelative(0.08f, 0.14f, -0.04f, 0.34f, -0.2f, 0.34f)
                horizontalLineToRelative(-1.75f)
                curveToRelative(-0.08f, 0f, -0.16f, -0.05f, -0.2f, -0.12f)
                lineToRelative(-2.96f, -5.31f)
                reflectiveCurveToRelative(-0.02f, -0.06f, -0.03f, -0.09f)
                curveToRelative(0f, 0.03f, -0.01f, 0.06f, -0.03f, 0.09f)
                lineToRelative(-2.97f, 5.31f)
                curveToRelative(-0.04f, 0.07f, -0.11f, 0.12f, -0.19f, 0.12f)
                horizontalLineToRelative(-1.75f)
                curveToRelative(-0.16f, 0f, -0.28f, -0.2f, -0.2f, -0.34f)
                lineToRelative(2.9f, -5.19f)
                lineToRelative(-2.9f, -5.2f)
                curveToRelative(-0.07f, -0.13f, 0.02f, -0.31f, 0.16f, -0.33f)
                horizontalLineToRelative(0f)
                close()
            }
        }.build()

        return _LogoXamarin!!
    }

@Suppress("ObjectPropertyName")
private var _LogoXamarin: ImageVector? = null
