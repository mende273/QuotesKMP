package mende273.quoteskmp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.feature.detail.QuoteDetailScreen
import mende273.quoteskmp.ui.feature.detail.QuoteDetailViewModel
import mende273.quoteskmp.ui.feature.favourites.FavouritesScreen
import mende273.quoteskmp.ui.feature.favourites.FavouritesViewModel
import mende273.quoteskmp.ui.feature.home.HomeScreen
import mende273.quoteskmp.ui.feature.home.HomeViewModel
import mende273.quoteskmp.ui.feature.random.RandomQuoteScreen
import mende273.quoteskmp.ui.feature.random.RandomQuoteViewModel
import mende273.quoteskmp.ui.feature.today.QuoteOfTheDayScreen
import mende273.quoteskmp.ui.feature.today.QuoteOfTheDayViewModel
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun AppNavigation(
    navHostController: NavHostController
) {
    NavHost(
        navHostController,
        startDestination = Screen.Home
    ) {
        composable<Screen.Favourites> {
            FavouritesScreen(
                modifier = Modifier.fillMaxSize(),
                viewModel = koinNavViewModel<FavouritesViewModel>(),
                onNavigateToQuoteDetails = {
                    navHostController.navigate(Screen.QuoteDetail(it.id, it.content, it.author))
                }
            )
        }

        composable<Screen.QuoteDetail> { backStack ->
            val quoteDetail = backStack.toRoute<Screen.QuoteDetail>()
            QuoteDetailScreen(
                viewModel = koinNavViewModel<QuoteDetailViewModel>(),
                quote = Quote(quoteDetail.id, quoteDetail.content, quoteDetail.author),
                onNavigateBack = {
                    navHostController.navigateUp()
                }
            )
        }

        composable<Screen.RandomQuote> {
            RandomQuoteScreen(
                viewModel = koinNavViewModel<RandomQuoteViewModel>(),
                onNavigateBack = {
                    navHostController.navigateUp()
                }
            )
        }

        composable<Screen.QuoteOfTheDay> {
            QuoteOfTheDayScreen(
                viewModel = koinNavViewModel<QuoteOfTheDayViewModel>()
            )
        }

        composable<Screen.Home> {
            HomeScreen(
                modifier = Modifier.fillMaxSize(),
                viewModel = koinNavViewModel<HomeViewModel>(),
                onNavigateToQuoteDetails = {
                    navHostController.navigate(Screen.QuoteDetail(it.id, it.content, it.author))
                },
                onNavigateToRandomQuote = {
                    navHostController.navigate(Screen.RandomQuote)
                }
            )
        }
    }
}
