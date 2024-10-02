package mende273.quoteskmp.component.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mende273.quoteskmp.ui.theme.QuotesKmpTheme
import mende273.quoteskmp.ui.common.component.LargeQuoteCard

@Preview
@Composable
private fun LargeQuoteCardPreview() {
    QuotesKmpTheme {
        LargeQuoteCard("this is a preview quote", "author name")
    }
}

@Preview
@Composable
private fun LargeQuoteCardDarkPreview() {
    QuotesKmpTheme(darkTheme = true) {
        LargeQuoteCard("this is a preview quote", "author name")
    }
}