package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoConfluence: ImageVector
    get() {
        if (_LogoConfluence != null) {
            return _LogoConfluence!!
        }
        _LogoConfluence = ImageVector.Builder(
            name = "LogoConfluence",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF1868DB))) {
                moveTo(0f, 6f)
                curveTo(0f, 2.69f, 2.69f, 0f, 6f, 0f)
                horizontalLineToRelative(12f)
                curveTo(21.32f, 0f, 24f, 2.69f, 24f, 6f)
                verticalLineToRelative(12f)
                curveToRelative(0f, 3.31f, -2.69f, 6f, -6f, 6f)
                horizontalLineTo(6f)
                curveTo(2.69f, 24f, 0f, 21.31f, 0f, 18f)
                verticalLineTo(6f)
                close()
            }
            group(
                clipPathData = PathData {
                    moveTo(5.79f, 6.09f)
                    horizontalLineToRelative(12.38f)
                    verticalLineToRelative(11.84f)
                    horizontalLineToRelative(-12.38f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color.White)) {
                    moveTo(17.37f, 14.27f)
                    curveToRelative(-3.7f, -1.79f, -4.79f, -2.06f, -6.35f, -2.06f)
                    curveToRelative(-1.83f, 0f, -3.39f, 0.76f, -4.79f, 2.9f)
                    lineToRelative(-0.23f, 0.35f)
                    curveToRelative(-0.19f, 0.29f, -0.23f, 0.39f, -0.23f, 0.51f)
                    reflectiveCurveToRelative(0.06f, 0.23f, 0.29f, 0.37f)
                    lineToRelative(2.35f, 1.46f)
                    curveToRelative(0.12f, 0.08f, 0.23f, 0.12f, 0.33f, 0.12f)
                    curveToRelative(0.12f, 0f, 0.21f, -0.06f, 0.33f, -0.25f)
                    lineToRelative(0.37f, -0.58f)
                    curveToRelative(0.58f, -0.89f, 1.1f, -1.17f, 1.77f, -1.17f)
                    curveToRelative(0.58f, 0f, 1.27f, 0.16f, 2.12f, 0.58f)
                    lineToRelative(2.46f, 1.15f)
                    curveToRelative(0.25f, 0.12f, 0.52f, 0.06f, 0.64f, -0.23f)
                    lineToRelative(1.17f, -2.55f)
                    curveToRelative(0.12f, -0.29f, 0.04f, -0.47f, -0.25f, -0.62f)
                    close()
                    moveTo(6.58f, 9.76f)
                    curveToRelative(3.7f, 1.79f, 4.79f, 2.06f, 6.35f, 2.06f)
                    curveToRelative(1.83f, 0f, 3.39f, -0.76f, 4.79f, -2.9f)
                    lineToRelative(0.23f, -0.35f)
                    curveToRelative(0.19f, -0.29f, 0.23f, -0.39f, 0.23f, -0.51f)
                    reflectiveCurveToRelative(-0.06f, -0.23f, -0.29f, -0.37f)
                    lineToRelative(-2.35f, -1.46f)
                    curveToRelative(-0.12f, -0.08f, -0.23f, -0.12f, -0.33f, -0.12f)
                    curveToRelative(-0.12f, 0f, -0.21f, 0.06f, -0.33f, 0.25f)
                    lineToRelative(-0.37f, 0.58f)
                    curveToRelative(-0.58f, 0.89f, -1.1f, 1.17f, -1.77f, 1.17f)
                    curveToRelative(-0.58f, 0f, -1.27f, -0.16f, -2.12f, -0.58f)
                    lineToRelative(-2.45f, -1.15f)
                    curveToRelative(-0.25f, -0.12f, -0.52f, -0.06f, -0.64f, 0.23f)
                    lineToRelative(-1.17f, 2.55f)
                    curveToRelative(-0.12f, 0.29f, -0.04f, 0.47f, 0.25f, 0.62f)
                    close()
                }
            }
        }.build()

        return _LogoConfluence!!
    }

@Suppress("ObjectPropertyName")
private var _LogoConfluence: ImageVector? = null
