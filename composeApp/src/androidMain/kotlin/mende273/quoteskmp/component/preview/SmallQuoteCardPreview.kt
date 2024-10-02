package mende273.quoteskmp.component.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import mende273.quoteskmp.component.parameter.QuotePreviewParameter
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.theme.QuotesKmpTheme
import mende273.quoteskmp.ui.common.component.SmallQuoteCard

@Preview
@Composable
private fun SmallQuoteCardPreview(
    @PreviewParameter(QuotePreviewParameter::class) quote: Quote
) {
    SmallQuoteCard(
        quote = quote,
        onNavigateToQuoteDetails = {}
    )
}

@Preview
@Composable
private fun SmallQuoteCardDarkPreview(
    @PreviewParameter(QuotePreviewParameter::class) quote: Quote
) {
    QuotesKmpTheme(darkTheme = true) {
        SmallQuoteCard(
            quote = quote,
            onNavigateToQuoteDetails = {}
        )
    }
}