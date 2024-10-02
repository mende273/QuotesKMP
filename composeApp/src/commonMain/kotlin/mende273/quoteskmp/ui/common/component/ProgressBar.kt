package mende273.quoteskmp.ui.common.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import mende273.quoteskmp.ui.theme.PrimaryTextColor
import mende273.quoteskmp.ui.theme.TertiaryColor

@Composable
fun ProgressBar() {
    CircularProgressIndicator(
        color = TertiaryColor,
        trackColor = PrimaryTextColor
    )
}
