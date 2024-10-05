package mende273.quoteskmp.ui.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.component.FullSizeBox
import mende273.quoteskmp.ui.common.component.QuotesColumn
import mende273.quoteskmp.ui.common.component.TopBar
import mende273.quoteskmp.ui.common.component.UiStateWrapper
import mende273.quoteskmp.ui.common.menu.MenuItem
import mende273.quoteskmp.ui.common.state.UIState
import org.jetbrains.compose.resources.stringResource
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.action_random
import quoteskmp.composeapp.generated.resources.baseline_random
import quoteskmp.composeapp.generated.resources.screen_home

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    onNavigateToQuoteDetails: (Quote) -> Unit,
    onNavigateToRandomQuote: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreenContents(
        modifier = modifier,
        uiState = uiState,
        onNavigateToRandomQuote = onNavigateToRandomQuote,
        onNavigateToQuoteDetails = onNavigateToQuoteDetails
    )
}

@Composable
fun HomeScreenContents(
    modifier: Modifier,
    uiState: UIState<List<Quote>>,
    onNavigateToRandomQuote: () -> Unit,
    onNavigateToQuoteDetails: (Quote) -> Unit
) {
    Column(modifier = modifier) {
        TopBar(
            title = stringResource(Res.string.screen_home),
            menuItem = MenuItem(
                Res.string.action_random,
                Res.drawable.baseline_random
            ),
            onMenuItemClick = onNavigateToRandomQuote
        )

        UiStateWrapper(
            uiState = uiState,
            onSuccessWithData = { data ->
                FullSizeBox(contentAlignment = Alignment.TopCenter) {
                    QuotesColumn(
                        quotes = data,
                        onNavigateToQuoteDetails = onNavigateToQuoteDetails
                    )
                }
            }
        )
    }
}
