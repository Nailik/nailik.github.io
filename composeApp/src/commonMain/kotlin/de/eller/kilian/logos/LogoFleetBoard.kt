package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoFleetBoard: ImageVector
    get() {
        if (_LogoFleetBoard != null) {
            return _LogoFleetBoard!!
        }
        _LogoFleetBoard = ImageVector.Builder(
            name = "LogoFleetBoard",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(0f, 7.37f)
                horizontalLineToRelative(4.05f)
                verticalLineToRelative(0.78f)
                horizontalLineTo(1f)
                verticalLineToRelative(0.95f)
                horizontalLineToRelative(2.66f)
                verticalLineToRelative(0.78f)
                horizontalLineTo(1f)
                reflectiveCurveToRelative(0f, 1.55f, 0f, 1.55f)
                horizontalLineTo(0f)
                verticalLineToRelative(-4.05f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(5.01f, 7.43f)
                horizontalLineToRelative(1.1f)
                verticalLineToRelative(3.19f)
                horizontalLineToRelative(2.54f)
                reflectiveCurveToRelative(0f, 0.81f, 0f, 0.81f)
                horizontalLineToRelative(-3.64f)
                verticalLineToRelative(-4f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(14.75f, 7.45f)
                horizontalLineToRelative(4.24f)
                verticalLineToRelative(0.75f)
                horizontalLineToRelative(-3.03f)
                verticalLineToRelative(0.83f)
                horizontalLineToRelative(2.35f)
                verticalLineToRelative(0.74f)
                horizontalLineToRelative(-2.35f)
                reflectiveCurveToRelative(0f, 0.91f, 0f, 0.91f)
                horizontalLineToRelative(3.05f)
                reflectiveCurveToRelative(0f, 0.75f, 0f, 0.75f)
                horizontalLineToRelative(-4.27f)
                verticalLineToRelative(-3.97f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(21.42f, 8.22f)
                horizontalLineToRelative(-1.56f)
                verticalLineToRelative(-0.82f)
                horizontalLineToRelative(4.13f)
                verticalLineToRelative(0.82f)
                horizontalLineToRelative(-1.56f)
                verticalLineToRelative(3.2f)
                horizontalLineToRelative(-1f)
                verticalLineToRelative(-3.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(0f, 12.59f)
                reflectiveCurveToRelative(0.02f, -0.04f, 0.04f, -0.04f)
                horizontalLineToRelative(2.18f)
                curveToRelative(1.23f, 0f, 1.85f, 0.35f, 1.85f, 1.05f)
                curveToRelative(0f, 0.41f, -0.24f, 0.7f, -0.72f, 0.87f)
                curveToRelative(0.59f, 0.18f, 0.89f, 0.5f, 0.89f, 0.97f)
                curveToRelative(0f, 0.39f, -0.16f, 0.68f, -0.49f, 0.88f)
                curveToRelative(-0.33f, 0.2f, -0.8f, 0.3f, -1.43f, 0.3f)
                horizontalLineTo(0.04f)
                reflectiveCurveToRelative(-0.04f, -0.02f, -0.04f, -0.04f)
                verticalLineToRelative(-3.99f)
                close()
                moveTo(2.81f, 13.37f)
                curveToRelative(-0.13f, -0.07f, -0.35f, -0.11f, -0.64f, -0.11f)
                horizontalLineToRelative(-1.14f)
                verticalLineToRelative(0.92f)
                horizontalLineToRelative(1.19f)
                curveToRelative(0.27f, 0f, 0.47f, -0.04f, 0.6f, -0.11f)
                reflectiveCurveToRelative(0.19f, -0.2f, 0.19f, -0.36f)
                reflectiveCurveToRelative(-0.07f, -0.27f, -0.2f, -0.34f)
                close()
                moveTo(3.17f, 15.39f)
                curveToRelative(0f, -0.19f, -0.07f, -0.32f, -0.22f, -0.41f)
                curveToRelative(-0.15f, -0.09f, -0.39f, -0.13f, -0.71f, -0.13f)
                horizontalLineToRelative(-1.21f)
                verticalLineToRelative(1.07f)
                horizontalLineToRelative(1.21f)
                curveToRelative(0.33f, 0f, 0.57f, -0.04f, 0.71f, -0.13f)
                curveToRelative(0.15f, -0.08f, 0.22f, -0.22f, 0.22f, -0.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(4.75f, 14.52f)
                curveToRelative(0f, -0.43f, 0.09f, -0.81f, 0.27f, -1.12f)
                reflectiveCurveToRelative(0.43f, -0.56f, 0.76f, -0.73f)
                curveToRelative(0.33f, -0.17f, 0.72f, -0.25f, 1.17f, -0.25f)
                reflectiveCurveToRelative(0.84f, 0.08f, 1.17f, 0.25f)
                curveToRelative(0.33f, 0.17f, 0.58f, 0.41f, 0.76f, 0.73f)
                curveToRelative(0.18f, 0.31f, 0.27f, 0.69f, 0.27f, 1.12f)
                reflectiveCurveToRelative(-0.09f, 0.81f, -0.27f, 1.12f)
                reflectiveCurveToRelative(-0.43f, 0.56f, -0.76f, 0.73f)
                curveToRelative(-0.33f, 0.17f, -0.72f, 0.26f, -1.18f, 0.26f)
                reflectiveCurveToRelative(-0.84f, -0.09f, -1.17f, -0.26f)
                reflectiveCurveToRelative(-0.58f, -0.41f, -0.76f, -0.73f)
                reflectiveCurveToRelative(-0.27f, -0.69f, -0.27f, -1.12f)
                close()
                moveTo(5.72f, 14.52f)
                curveToRelative(0f, 0.41f, 0.11f, 0.72f, 0.32f, 0.95f)
                reflectiveCurveToRelative(0.52f, 0.34f, 0.91f, 0.34f)
                reflectiveCurveToRelative(0.69f, -0.11f, 0.91f, -0.34f)
                reflectiveCurveToRelative(0.33f, -0.54f, 0.33f, -0.95f)
                reflectiveCurveToRelative(-0.11f, -0.73f, -0.32f, -0.95f)
                curveToRelative(-0.22f, -0.22f, -0.52f, -0.34f, -0.91f, -0.34f)
                reflectiveCurveToRelative(-0.69f, 0.11f, -0.91f, 0.34f)
                reflectiveCurveToRelative(-0.33f, 0.54f, -0.33f, 0.95f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(11.83f, 13.39f)
                lineToRelative(-1.37f, 3.23f)
                horizontalLineToRelative(-1.04f)
                lineToRelative(1.78f, -4.03f)
                horizontalLineToRelative(1.28f)
                lineToRelative(1.78f, 4.03f)
                horizontalLineToRelative(-1.07f)
                lineToRelative(-1.37f, -3.23f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(14.78f, 12.6f)
                horizontalLineToRelative(2.3f)
                curveToRelative(1.25f, 0f, 1.87f, 0.43f, 1.87f, 1.29f)
                curveToRelative(0f, 0.28f, -0.07f, 0.51f, -0.2f, 0.69f)
                curveToRelative(-0.13f, 0.18f, -0.42f, 0.37f, -0.68f, 0.47f)
                lineToRelative(1.04f, 1.57f)
                horizontalLineToRelative(-1.18f)
                lineToRelative(-0.91f, -1.43f)
                horizontalLineToRelative(-1.22f)
                verticalLineToRelative(1.43f)
                horizontalLineToRelative(-1.03f)
                verticalLineToRelative(-4.03f)
                close()
                moveTo(17.91f, 13.89f)
                curveToRelative(0f, -0.2f, -0.07f, -0.34f, -0.21f, -0.42f)
                curveToRelative(-0.14f, -0.08f, -0.36f, -0.12f, -0.68f, -0.12f)
                horizontalLineToRelative(-1.22f)
                verticalLineToRelative(1.11f)
                horizontalLineToRelative(1.21f)
                curveToRelative(0.3f, 0f, 0.53f, -0.04f, 0.68f, -0.13f)
                curveToRelative(0.15f, -0.09f, 0.22f, -0.23f, 0.22f, -0.43f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(19.82f, 12.6f)
                horizontalLineToRelative(1.82f)
                curveToRelative(0.77f, 0f, 1.45f, 0.11f, 1.85f, 0.45f)
                curveToRelative(0.4f, 0.34f, 0.52f, 0.9f, 0.52f, 1.56f)
                reflectiveCurveToRelative(-0.11f, 1.22f, -0.53f, 1.57f)
                curveToRelative(-0.42f, 0.35f, -1.13f, 0.44f, -1.92f, 0.44f)
                horizontalLineToRelative(-1.74f)
                verticalLineToRelative(-4.03f)
                close()
                moveTo(23.07f, 14.61f)
                curveToRelative(0f, -0.8f, -0.3f, -1.21f, -1.2f, -1.21f)
                horizontalLineToRelative(-1.07f)
                verticalLineToRelative(2.43f)
                horizontalLineToRelative(1f)
                curveToRelative(0.95f, 0f, 1.27f, -0.4f, 1.27f, -1.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE8441E))) {
                moveTo(9.43f, 7.45f)
                horizontalLineToRelative(4.24f)
                verticalLineToRelative(0.75f)
                horizontalLineToRelative(-3.03f)
                verticalLineToRelative(0.83f)
                horizontalLineToRelative(2.35f)
                verticalLineToRelative(0.74f)
                horizontalLineToRelative(-2.35f)
                reflectiveCurveToRelative(0f, 0.91f, 0f, 0.91f)
                horizontalLineToRelative(3.05f)
                reflectiveCurveToRelative(0f, 0.75f, 0f, 0.75f)
                horizontalLineToRelative(-4.27f)
                verticalLineToRelative(-3.97f)
                close()
            }
        }.build()

        return _LogoFleetBoard!!
    }

@Suppress("ObjectPropertyName")
private var _LogoFleetBoard: ImageVector? = null
