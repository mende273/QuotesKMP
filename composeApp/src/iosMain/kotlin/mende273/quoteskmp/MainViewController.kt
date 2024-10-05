package mende273.quoteskmp

import androidx.compose.ui.window.ComposeUIViewController
import mende273.quoteskmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }