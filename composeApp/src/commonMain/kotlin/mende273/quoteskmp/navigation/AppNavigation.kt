package mende273.quoteskmp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                    navHostController.navigate(Screen.QuoteDetail.getRoute(quote = it))
                }
            )
        }

        composable(
            route = Screen.QuoteDetail.ROUTE,
            arguments = Screen.QuoteDetail.getNavArguments()
        ) { backStack ->
            val quote = with(backStack.arguments) {
                Quote(
                    id = this?.getLong(Screen.QuoteDetail.ARGUMENT_ID) ?: 0,
                    content = this?.getString(Screen.QuoteDetail.ARGUMENT_CONTENT) ?: "",
                    author = this?.getString(Screen.QuoteDetail.ARGUMENT_AUTHOR) ?: ""
                )
            }
            QuoteDetailScreen(
                viewModel = koinNavViewModel<QuoteDetailViewModel>(),
                quote = quote,
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
                    navHostController.navigate(Screen.QuoteDetail.getRoute(quote = it))
                },
                onNavigateToRandomQuote = {
                    navHostController.navigate(Screen.RandomQuote)
                }
            )
        }
    }
}
