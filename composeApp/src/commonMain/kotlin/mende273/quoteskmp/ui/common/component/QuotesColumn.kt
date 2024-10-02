package mende273.quoteskmp.ui.common.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.theme.spacing

@Composable
fun QuotesColumn(
    quotes: List<Quote>,
    onNavigateToQuoteDetails: (Quote) -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.normal)) {
        items(quotes) { quote ->
            SmallQuoteCard(
                quote = quote,
                onNavigateToQuoteDetails = { onNavigateToQuoteDetails(it) }
            )
        }
    }
}
