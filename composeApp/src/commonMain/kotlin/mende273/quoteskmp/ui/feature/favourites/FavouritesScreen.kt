package mende273.quoteskmp.ui.feature.favourites

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.component.FullSizeBox
import mende273.quoteskmp.ui.common.component.QuotesColumn
import mende273.quoteskmp.ui.common.component.TopBar
import mende273.quoteskmp.ui.common.component.UiStateWrapper
import mende273.quoteskmp.ui.common.state.UIState
import org.jetbrains.compose.resources.stringResource
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.screen_favourites

@Composable
fun FavouritesScreen(
    modifier: Modifier = Modifier,
    //  viewModel: FavouritesViewModel,
    onNavigateToQuoteDetails: (Quote) -> Unit
) {
    //val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val dumbUiState = UIState.SuccessWithData(
        listOf(
            Quote(
                id = 1,
                content = "Everything comes to him who hustles while he waits.",
                author = "Thomas Edison"
            ),
            Quote(
                id = 2,
                content = "Change in all things is sweet.",
                author = "Aristotle"
            ),
            Quote(
                id = 3,
                content = "I never think of the future - it comes soon enough.",
                author = "Albert Einstein"
            ),
            Quote(
                id = 4,
                content = "As a cure for worrying, work is better than whisky.",
                author = "Thomas Edison"
            )
        )
    )

    FavoritesScreenContents(
        modifier = modifier,
        uiState = dumbUiState,
        onNavigateToQuoteDetails = onNavigateToQuoteDetails
    )
}

@Composable
fun FavoritesScreenContents(
    modifier: Modifier,
    uiState: UIState<List<Quote>>,
    onNavigateToQuoteDetails: (Quote) -> Unit
) {
    Column(modifier = modifier) {
        TopBar(
            title = stringResource(Res.string.screen_favourites)
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
