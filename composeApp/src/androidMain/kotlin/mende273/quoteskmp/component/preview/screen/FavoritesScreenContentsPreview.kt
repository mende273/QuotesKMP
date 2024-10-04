package mende273.quoteskmp.component.preview.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import mende273.quoteskmp.component.parameter.ListOfQuotesPreviewParameter
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.state.UIState
import mende273.quoteskmp.ui.feature.favourites.FavoritesScreenContents
import mende273.quoteskmp.ui.theme.QuotesKmpTheme

@Preview(showBackground = true)
@Composable
private fun FavoritesScreenContentsPreview(
    @PreviewParameter(ListOfQuotesPreviewParameter::class) quotes: List<Quote>
) {
    QuotesKmpTheme {
        FavoritesScreenContents(
            modifier = Modifier,
            uiState = UIState.SuccessWithData(quotes),
            onNavigateToQuoteDetails = {}
        )
    }
}