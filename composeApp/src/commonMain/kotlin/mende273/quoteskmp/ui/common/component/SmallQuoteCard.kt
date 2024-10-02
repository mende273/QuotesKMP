package mende273.quoteskmp.ui.common.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import mende273.quoteskmp.ui.common.preview.parameter.QuotePreviewParameter
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.theme.QuotesKmpTheme
import mende273.quoteskmp.theme.TertiaryColor
import mende273.quoteskmp.theme.mediumTextStyle
import mende273.quoteskmp.theme.spacing
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter

@Composable
fun SmallQuoteCard(quote: Quote, onNavigateToQuoteDetails: (Quote) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onNavigateToQuoteDetails(quote) },
        colors = CardDefaults.cardColors(
            containerColor = TertiaryColor
        )
    ) {
        Column(
            modifier = Modifier
                .padding(MaterialTheme.spacing.normal)
                .height(100.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = quote.content,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = mediumTextStyle()
            )
        }
    }
}

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
