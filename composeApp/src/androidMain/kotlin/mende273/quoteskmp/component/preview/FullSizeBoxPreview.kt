package mende273.quoteskmp.component.preview

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mende273.quoteskmp.ui.common.component.FullSizeBox

@Preview
@Composable
private fun FullSizeBoxPreview() {
    FullSizeBox {
        Text(text = "contents go here")
    }
}