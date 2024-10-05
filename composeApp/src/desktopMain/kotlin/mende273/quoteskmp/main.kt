package mende273.quoteskmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import mende273.quoteskmp.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "QuotesKMP",
    ) {
        initKoin()
        App()
    }
}