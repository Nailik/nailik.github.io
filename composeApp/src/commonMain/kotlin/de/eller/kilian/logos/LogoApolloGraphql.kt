package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoApolloGraphql: ImageVector
    get() {
        if (_LogoApolloGraphql != null) {
            return _LogoApolloGraphql!!
        }
        _LogoApolloGraphql = ImageVector.Builder(
            name = "LogoApolloGraphql",
            defaultWidth = 25.54.dp,
            defaultHeight = 24.dp,
            viewportWidth = 25.54f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12.77f, 0f)
                curveTo(6.14f, 0f, 0.77f, 5.37f, 0.77f, 12f)
                reflectiveCurveToRelative(5.37f, 12f, 12f, 12f)
                reflectiveCurveToRelative(12f, -5.37f, 12f, -12f)
                curveToRelative(0f, -1.13f, -0.16f, -2.26f, -0.47f, -3.34f)
                curveToRelative(-0.13f, -0.31f, -0.48f, -0.45f, -0.78f, -0.33f)
                curveToRelative(-0.29f, 0.12f, -0.44f, 0.44f, -0.34f, 0.74f)
                horizontalLineToRelative(0f)
                curveToRelative(0.26f, 0.94f, 0.4f, 1.93f, 0.4f, 2.93f)
                curveToRelative(0f, 2.87f, -1.13f, 5.62f, -3.16f, 7.64f)
                curveToRelative(-2.02f, 2.03f, -4.77f, 3.17f, -7.64f, 3.16f)
                curveToRelative(-2.87f, 0f, -5.62f, -1.13f, -7.64f, -3.16f)
                curveToRelative(-2.03f, -2.02f, -3.17f, -4.77f, -3.16f, -7.64f)
                curveToRelative(0f, -2.87f, 1.13f, -5.62f, 3.16f, -7.64f)
                curveToRelative(2.02f, -2.03f, 4.77f, -3.17f, 7.64f, -3.16f)
                curveToRelative(2.58f, 0f, 5.01f, 0.9f, 6.96f, 2.54f)
                curveToRelative(-0.3f, 0.75f, 0.07f, 1.6f, 0.83f, 1.9f)
                curveToRelative(0.75f, 0.3f, 1.6f, -0.07f, 1.9f, -0.83f)
                curveToRelative(0.3f, -0.75f, -0.07f, -1.6f, -0.83f, -1.9f)
                curveToRelative(-0.33f, -0.13f, -0.7f, -0.14f, -1.04f, -0.01f)
                curveTo(18.42f, 1.03f, 15.64f, 0f, 12.77f, 0f)
                close()
                moveTo(11.33f, 5.88f)
                lineToRelative(-4.2f, 10.9f)
                horizontalLineToRelative(2.63f)
                lineToRelative(0.69f, -1.85f)
                horizontalLineToRelative(3.97f)
                lineToRelative(-0.72f, -2.04f)
                horizontalLineToRelative(-2.61f)
                lineToRelative(1.7f, -4.69f)
                lineToRelative(3.02f, 8.58f)
                horizontalLineToRelative(2.63f)
                lineToRelative(-4.2f, -10.9f)
                horizontalLineToRelative(-2.91f)
                close()
            }
        }.build()

        return _LogoApolloGraphql!!
    }

@Suppress("ObjectPropertyName")
private var _LogoApolloGraphql: ImageVector? = null
