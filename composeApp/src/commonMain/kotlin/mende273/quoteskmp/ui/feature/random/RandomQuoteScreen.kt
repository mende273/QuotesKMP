package mende273.quoteskmp.ui.feature.random

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.component.FullSizeBox
import mende273.quoteskmp.ui.common.component.LargeQuoteCard
import mende273.quoteskmp.ui.common.component.TopBar
import mende273.quoteskmp.ui.common.component.UiStateWrapper
import mende273.quoteskmp.ui.common.menu.MenuItem
import mende273.quoteskmp.ui.common.state.UIState
import org.jetbrains.compose.resources.stringResource
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.action_random
import quoteskmp.composeapp.generated.resources.baseline_refresh_24
import quoteskmp.composeapp.generated.resources.screen_random_quote

@Composable
fun RandomQuoteScreen(
    // viewModel: RandomQuoteViewModel,
    onNavigateBack: () -> Unit
) {

    val dumbUiState = UIState.SuccessWithData(
        Quote(
            1,
            "Everything comes to him who hustles while he waits.",
            "Thomas Edison"
        )
    )

    //  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val menuItems by remember {
        mutableStateOf(
            MenuItem(
                Res.string.action_random,
                Res.drawable.baseline_refresh_24
            )
        )
    }

    LaunchedEffect(Unit) {
        //viewModel.getRandomQuote()
    }

    RandomQuoteScreenContents(
        uiState = dumbUiState,
        menuItem = menuItems,
        onNavigateBack = onNavigateBack,
        onGetNewRandomQuote = {
            // viewModel::getRandomQuote
        }
    )
}

@Composable
fun RandomQuoteScreenContents(
    uiState: UIState<Quote>,
    menuItem: MenuItem,
    onNavigateBack: () -> Unit,
    onGetNewRandomQuote: () -> Unit
) {
    Column {
        TopBar(
            title = stringResource(Res.string.screen_random_quote),
            menuItem = menuItem,
            isBackButtonEnabled = true,
            onNavigateBack = onNavigateBack,
            onMenuItemClick = onGetNewRandomQuote
        )

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
