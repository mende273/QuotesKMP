package mende273.quoteskmp.component.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mende273.quoteskmp.theme.QuotesKmpTheme
import mende273.quoteskmp.ui.common.component.ErrorText

@Preview
@Composable
private fun ErrorTextPreview() {
    QuotesKmpTheme {
        ErrorText(reason = "text to display")
    }
}