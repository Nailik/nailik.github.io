package de.eller.kilian.logos

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Logos.LogoProcessing: ImageVector
    get() {
        if (_LogoProcessing != null) {
            return _LogoProcessing!!
        }
        _LogoProcessing = ImageVector.Builder(
            name = "LogoProcessing",
            defaultWidth = 24.02.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.02f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF0468FF)),
                strokeLineWidth = 4f
            ) {
                moveTo(13.43f, 17.72f)
                curveToRelative(11.44f, 0f, 11.44f, -15.25f, 0f, -15.25f)
            }
            path(
                stroke = SolidColor(Color(0xFF1F34AB)),
                strokeLineWidth = 4f
            ) {
                moveTo(13.43f, 6.28f)
                lineTo(1.99f, 21.53f)
            }
            path(
                stroke = SolidColor(Color(0xFF85AEFF)),
                strokeLineWidth = 4f
            ) {
                moveTo(1.99f, 10.09f)
                lineToRelative(3.81f, 7.63f)
            }
        }.build()

        return _LogoProcessing!!
    }

@Suppress("ObjectPropertyName")
private var _LogoProcessing: ImageVector? = null
