package mende273.quoteskmp.ui.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.component.FullSizeBox
import mende273.quoteskmp.ui.common.component.LargeQuoteCard
import mende273.quoteskmp.ui.common.component.TopBar
import mende273.quoteskmp.ui.common.menu.MenuItem
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.action_favourite
import quoteskmp.composeapp.generated.resources.baseline_favorite_24
import quoteskmp.composeapp.generated.resources.baseline_favorite_border_24

@Composable
fun QuoteDetailScreen(
    viewModel: QuoteDetailViewModel,
    quote: Quote,
    onNavigateBack: () -> Unit
) {
    val isFavorite by viewModel.isFavorite.collectAsStateWithLifecycle()

    var menuItem by remember {
        mutableStateOf(
            MenuItem(
                Res.string.action_favourite,
                Res.drawable.baseline_favorite_border_24
            )
        )
    }

    LaunchedEffect(key1 = quote.id, block = {
        viewModel.init(quote)
    })

    LaunchedEffect(key1 = isFavorite) {
        menuItem = menuItem.copy(
            icon =
            if (isFavorite) {
                Res.drawable.baseline_favorite_24
            } else {
                Res.drawable.baseline_favorite_border_24
            }
        )
    }

    QuoteDetailScreenContents(
        quote = quote,
        menuItem = menuItem,
        onToggleFavorite = viewModel::toggleFavourite,
        onNavigateBack = onNavigateBack
    )
}

@Composable
fun QuoteDetailScreenContents(
    quote: Quote,
    menuItem: MenuItem? = null,
    onToggleFavorite: () -> Unit,
    onNavigateBack: () -> Unit
) {
    Column {
        TopBar(
            isBackButtonEnabled = true,
            onNavigateBack = onNavigateBack,
            menuItem = menuItem,
            onMenuItemClick = onToggleFavorite
        )

        FullSizeBox {
            LargeQuoteCard(quote.content, quote.author)
        }
    }
}
