package de.eller.kilian

import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.delay
import org.jetbrains.skiko.SystemTheme.DARK
import org.jetbrains.skiko.currentSystemTheme

fun main() = application {

    val icon = rememberVectorPainter(Favicon)

    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
        icon = icon,
    ) {
        App(
            darkMode = dynamicIsDarkSystemTheme(),
        )
    }
}

@Composable
fun dynamicIsDarkSystemTheme(): Boolean {
    return produceState(initialValue = currentSystemTheme == DARK) {
        while (true) {
            delay(1000)
            value = currentSystemTheme == DARK
        }
    }.value
}