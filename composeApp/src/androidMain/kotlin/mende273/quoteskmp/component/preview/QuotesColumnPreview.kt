package mende273.quoteskmp.component.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import mende273.quoteskmp.component.parameter.ListOfQuotesPreviewParameter
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.theme.QuotesKmpTheme
import mende273.quoteskmp.ui.common.component.QuotesColumn

@Preview
@Composable
private fun QuotesColumnPreview(
    @PreviewParameter(ListOfQuotesPreviewParameter::class) quotes: List<Quote>
) {
    QuotesKmpTheme {
        QuotesColumn(quotes = quotes, onNavigateToQuoteDetails = {})
    }
}