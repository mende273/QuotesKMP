package mende273.quoteskmp.ui.common.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import mende273.quoteskmp.theme.PrimaryTextColor
import mende273.quoteskmp.theme.TertiaryColor
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ProgressBar() {
    CircularProgressIndicator(
        color = TertiaryColor,
        trackColor = PrimaryTextColor
    )
}
