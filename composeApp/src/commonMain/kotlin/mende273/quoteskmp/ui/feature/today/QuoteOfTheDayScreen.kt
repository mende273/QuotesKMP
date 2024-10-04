package mende273.quoteskmp.ui.feature.today

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.component.FullSizeBox
import mende273.quoteskmp.ui.common.component.LargeQuoteCard
import mende273.quoteskmp.ui.common.component.TopBar
import mende273.quoteskmp.ui.common.component.UiStateWrapper
import mende273.quoteskmp.ui.common.state.UIState
import org.jetbrains.compose.resources.stringResource
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.screen_quote_today

@Composable
fun QuoteOfTheDayScreen(
    // viewModel: QuoteOfTheDayViewModel
) {
    LaunchedEffect(Unit) {
        //       viewModel.getRandomQuote()
    }

    // val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val dumbUiState = UIState.SuccessWithData<Quote>(
        Quote(
            1,
            "Everything comes to him who hustles while he waits.",
            "Thomas Edison"
        )
    )

    QuoteOfTheDayScreenContents(
        uiState = dumbUiState
    )
}

@Composable
fun QuoteOfTheDayScreenContents(
    uiState: UIState<Quote>
) {
    Column {
        TopBar(title = stringResource(Res.string.screen_quote_today))

        UiStateWrapper(
            uiState = uiState,
            onSuccessWithData = { quote ->
                FullSizeBox {
                    LargeQuoteCard(quote.content, quote.author)
                }
            }
        )
    }
}
