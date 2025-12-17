package de.eller.kilian.theme

import androidx.compose.runtime.Composable
import javax.swing.UIManager

@Composable
actual fun getContrastMode(): ContrastMode {
    val lookAndFeelName = UIManager.getLookAndFeel()?.name ?: ""
    return if (lookAndFeelName.contains("High Contrast", ignoreCase = true)) ContrastMode.HIGH
    else ContrastMode.NORMAL
}