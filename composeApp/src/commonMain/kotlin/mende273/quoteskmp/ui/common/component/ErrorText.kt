package mende273.quoteskmp.ui.common.component

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import mende273.quoteskmp.theme.QuotesKmpTheme
import mende273.quoteskmp.theme.mediumTextStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ErrorText(reason: String) {
    Text(
        modifier = Modifier.wrapContentSize(),
        text = reason,
        style = mediumTextStyle(),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun ErrorTextPreview() {
    QuotesKmpTheme {
        ErrorText(reason = "text to display")
    }
}
