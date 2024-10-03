package mende273.quoteskmp.component.preview.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import mende273.quoteskmp.component.parameter.QuotePreviewParameter
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.menu.MenuItem
import mende273.quoteskmp.ui.common.state.UIState
import mende273.quoteskmp.ui.feature.random.RandomQuoteScreenContents
import mende273.quoteskmp.ui.theme.QuotesKmpTheme
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.action_random
import quoteskmp.composeapp.generated.resources.baseline_refresh_24

@Preview(showBackground = true)
@Composable
private fun RandomQuoteScreenContentsPreview(
    @PreviewParameter(QuotePreviewParameter::class) quote: Quote
) {
    QuotesKmpTheme {
        RandomQuoteScreenContents(
            uiState = UIState.SuccessWithData(quote),
            menuItem = MenuItem(
                Res.string.action_random,
                Res.drawable.baseline_refresh_24
            ),
            onNavigateBack = { },
            onGetNewRandomQuote = {}
        )
    }
}