package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoObi: ImageVector
    get() {
        if (_LogoObi != null) {
            return _LogoObi!!
        }
        _LogoObi = ImageVector.Builder(
            name = "LogoObi",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFF7313)),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 0.25f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(19.38f, 13.31f)
                lineToRelative(0.15f, -2.85f)
                lineToRelative(-1.27f, -0.65f)
                lineToRelative(0.03f, -0.64f)
                lineToRelative(5.59f, 0f)
                lineToRelative(-0.03f, 0.61f)
                lineToRelative(-1.49f, 0.68f)
                lineToRelative(-0.14f, 2.88f)
                lineToRelative(1.38f, 0.71f)
                lineToRelative(-0.04f, 0.79f)
                lineToRelative(-5.77f, 0f)
                lineToRelative(0.04f, -0.71f)
                lineToRelative(1.55f, -0.82f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFF7313)),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 0.25f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(13.33f, 13.38f)
                horizontalLineToRelative(-0.85f)
                lineToRelative(0.05f, -1.05f)
                horizontalLineToRelative(0.85f)
                curveToRelative(0.45f, -0.02f, 0.65f, 0.38f, 0.53f, 0.64f)
                curveToRelative(0f, 0f, -0.04f, 0.39f, -0.59f, 0.41f)
                horizontalLineToRelative(0f)
                close()
                moveTo(13.43f, 11.34f)
                horizontalLineToRelative(-0.85f)
                lineToRelative(0.05f, -0.99f)
                horizontalLineToRelative(0.89f)
                curveToRelative(0.34f, 0f, 0.58f, 0.24f, 0.5f, 0.55f)
                curveToRelative(0f, 0f, -0.02f, 0.43f, -0.6f, 0.43f)
                horizontalLineToRelative(0f)
                close()
                moveTo(15.85f, 9.16f)
                reflectiveCurveToRelative(1.08f, -0.12f, 1.29f, 1.25f)
                curveToRelative(0f, 0f, 0.09f, 0.94f, -0.87f, 1.5f)
                curveToRelative(1.04f, 0.3f, 0.86f, 1.57f, 0.86f, 1.57f)
                curveToRelative(-0.32f, 1.44f, -1.79f, 1.35f, -1.79f, 1.35f)
                horizontalLineToRelative(-7.12f)
                lineToRelative(0.04f, -0.71f)
                lineToRelative(1.33f, -0.82f)
                lineToRelative(0.13f, -2.89f)
                lineToRelative(-1.24f, -0.6f)
                lineToRelative(0.04f, -0.64f)
                horizontalLineToRelative(7.34f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFF7313)),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 0.25f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(4.11f, 9.94f)
                horizontalLineToRelative(0.17f)
                curveToRelative(0.38f, 0f, 0.67f, 0.32f, 0.65f, 0.71f)
                lineToRelative(-0.13f, 2.58f)
                curveToRelative(-0.02f, 0.39f, -0.35f, 0.71f, -0.73f, 0.71f)
                horizontalLineToRelative(-0.17f)
                curveToRelative(-0.38f, 0f, -0.67f, -0.32f, -0.65f, -0.71f)
                lineToRelative(0.13f, -2.58f)
                curveToRelative(0.02f, -0.39f, 0.35f, -0.71f, 0.73f, -0.71f)
                horizontalLineToRelative(0f)
                close()
                moveTo(2.71f, 9.17f)
                horizontalLineToRelative(3.06f)
                curveToRelative(1.33f, 0f, 2.36f, 1.12f, 2.29f, 2.49f)
                lineToRelative(-0.03f, 0.68f)
                curveToRelative(-0.07f, 1.38f, -1.21f, 2.49f, -2.54f, 2.49f)
                horizontalLineToRelative(-3.06f)
                curveToRelative(-1.33f, 0f, -2.36f, -1.12f, -2.29f, -2.49f)
                lineToRelative(0.03f, -0.68f)
                curveToRelative(0.07f, -1.38f, 1.21f, -2.49f, 2.54f, -2.49f)
                horizontalLineToRelative(0f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(22.62f, 12.75f)
                curveToRelative(0f, -0.14f, 0.06f, -0.27f, 0.15f, -0.37f)
                curveToRelative(0.09f, -0.09f, 0.22f, -0.15f, 0.36f, -0.15f)
                reflectiveCurveToRelative(0.27f, 0.06f, 0.36f, 0.15f)
                curveToRelative(0.09f, 0.09f, 0.15f, 0.22f, 0.15f, 0.37f)
                reflectiveCurveToRelative(-0.06f, 0.27f, -0.15f, 0.37f)
                horizontalLineToRelative(0f)
                curveToRelative(-0.09f, 0.09f, -0.22f, 0.15f, -0.36f, 0.15f)
                reflectiveCurveToRelative(-0.26f, -0.06f, -0.36f, -0.15f)
                curveToRelative(0f, 0f, 0f, 0f, 0f, 0f)
                curveToRelative(-0.09f, -0.09f, -0.15f, -0.22f, -0.15f, -0.37f)
                horizontalLineToRelative(0f)
                close()
                moveTo(23.12f, 12.82f)
                horizontalLineToRelative(-0.11f)
                verticalLineToRelative(0.2f)
                horizontalLineToRelative(-0.09f)
                verticalLineToRelative(-0.52f)
                horizontalLineToRelative(0.26f)
                curveToRelative(0.07f, 0f, 0.13f, 0.04f, 0.15f, 0.09f)
                curveToRelative(0.01f, 0.02f, 0.02f, 0.05f, 0.02f, 0.07f)
                horizontalLineToRelative(0f)
                reflectiveCurveToRelative(0f, 0.05f, -0.02f, 0.07f)
                curveToRelative(-0.02f, 0.03f, -0.05f, 0.06f, -0.1f, 0.08f)
                lineToRelative(0.13f, 0.22f)
                horizontalLineToRelative(-0.12f)
                lineToRelative(-0.12f, -0.21f)
                horizontalLineToRelative(0f)
                close()
                moveTo(23.01f, 12.72f)
                curveToRelative(0.06f, 0f, 0.1f, 0f, 0.17f, 0f)
                horizontalLineToRelative(0f)
                reflectiveCurveToRelative(0.06f, -0.02f, 0.07f, -0.04f)
                curveToRelative(0f, 0f, 0f, -0.02f, 0f, -0.02f)
                curveToRelative(0f, 0f, 0f, -0.02f, 0f, -0.03f)
                curveToRelative(-0.01f, -0.02f, -0.04f, -0.04f, -0.08f, -0.04f)
                horizontalLineToRelative(-0.16f)
                verticalLineToRelative(0.13f)
                horizontalLineToRelative(0f)
                close()
                moveTo(22.84f, 12.46f)
                curveToRelative(-0.07f, 0.08f, -0.12f, 0.18f, -0.12f, 0.3f)
                reflectiveCurveToRelative(0.05f, 0.22f, 0.12f, 0.3f)
                horizontalLineToRelative(0f)
                curveToRelative(0.07f, 0.08f, 0.17f, 0.12f, 0.29f, 0.12f)
                reflectiveCurveToRelative(0.21f, -0.05f, 0.29f, -0.12f)
                horizontalLineToRelative(0f)
                curveToRelative(0.07f, -0.08f, 0.12f, -0.18f, 0.12f, -0.3f)
                reflectiveCurveToRelative(-0.05f, -0.22f, -0.12f, -0.3f)
                curveToRelative(-0.07f, -0.08f, -0.18f, -0.12f, -0.29f, -0.12f)
                reflectiveCurveToRelative(-0.21f, 0.05f, -0.29f, 0.12f)
                horizontalLineToRelative(0f)
                close()
            }
        }.build()

        return _LogoObi!!
    }

@Suppress("ObjectPropertyName")
private var _LogoObi: ImageVector? = null
