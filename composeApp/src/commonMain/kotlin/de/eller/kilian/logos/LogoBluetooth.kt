package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoBluetooth: ImageVector
    get() {
        if (_LogoBluetooth != null) {
            return _LogoBluetooth!!
        }
        _LogoBluetooth = ImageVector.Builder(
            name = "LogoBluetooth",
            defaultWidth = 24.01.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.01f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF0A3D91))) {
                moveTo(11.3f, 0f)
                lineTo(12.72f, 0f)
                arcTo(7.16f, 7.16f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19.88f, 7.16f)
                lineTo(19.88f, 16.84f)
                arcTo(7.16f, 7.16f, 0f, isMoreThanHalf = false, isPositiveArc = true, 12.72f, 24f)
                lineTo(11.3f, 24f)
                arcTo(7.16f, 7.16f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4.14f, 16.84f)
                lineTo(4.14f, 7.16f)
                arcTo(7.16f, 7.16f, 0f, isMoreThanHalf = false, isPositiveArc = true, 11.3f, 0f)
                close()
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1.3f
            ) {
                moveTo(8.25f, 7.89f)
                lineToRelative(7.5f, 7.55f)
                lineToRelative(-3.61f, 4.38f)
                verticalLineTo(4.18f)
                lineToRelative(3.61f, 4.18f)
                lineToRelative(-7.5f, 7.35f)
            }
        }.build()

        return _LogoBluetooth!!
    }

@Suppress("ObjectPropertyName")
private var _LogoBluetooth: ImageVector? = null
