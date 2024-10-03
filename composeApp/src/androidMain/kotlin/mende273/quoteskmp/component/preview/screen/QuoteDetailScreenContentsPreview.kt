package mende273.quoteskmp.component.preview.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import mende273.quoteskmp.ui.feature.detail.QuoteDetailScreenContents
import mende273.quoteskmp.component.parameter.QuotePreviewParameter
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.menu.MenuItem
import mende273.quoteskmp.ui.theme.QuotesKmpTheme
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.action_favourite
import quoteskmp.composeapp.generated.resources.baseline_favorite_border_24

@Preview(showBackground = true)
@Composable
private fun QuoteDetailScreenContentsPreview(
    @PreviewParameter(QuotePreviewParameter::class) quote: Quote
) {
    QuotesKmpTheme {
        QuoteDetailScreenContents(
            quote = quote,
            menuItem = MenuItem(
                Res.string.action_favourite,
                Res.drawable.baseline_favorite_border_24
            ),
            onToggleFavorite = {},
            onNavigateBack = {}
        )
    }
}
