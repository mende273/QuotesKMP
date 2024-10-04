package mende273.quoteskmp.component.preview.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import mende273.quoteskmp.component.parameter.QuotePreviewParameter
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.state.UIState
import mende273.quoteskmp.ui.feature.today.QuoteOfTheDayScreenContents
import mende273.quoteskmp.ui.theme.QuotesKmpTheme

@Preview(showBackground = true)
@Composable
private fun QuoteOfTheDayScreenContentsPreview(
    @PreviewParameter(QuotePreviewParameter::class) quote: Quote
) {
    QuotesKmpTheme {
        QuoteOfTheDayScreenContents(
            uiState = UIState.SuccessWithData(quote)
        )
    }
}