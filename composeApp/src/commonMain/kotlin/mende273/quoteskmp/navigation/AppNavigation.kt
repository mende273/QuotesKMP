package mende273.quoteskmp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.feature.detail.QuoteDetailScreen
import mende273.quoteskmp.ui.feature.favourites.FavouritesScreen
import mende273.quoteskmp.ui.feature.home.HomeScreen
import mende273.quoteskmp.ui.feature.random.RandomQuoteScreen
import mende273.quoteskmp.ui.feature.today.QuoteOfTheDayScreen

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
                    id = this?.getInt(Screen.QuoteDetail.ARGUMENT_ID) ?: 0,
                    content = this?.getString(Screen.QuoteDetail.ARGUMENT_CONTENT) ?: "",
                    author = this?.getString(Screen.QuoteDetail.ARGUMENT_AUTHOR) ?: ""
                )
            }
            QuoteDetailScreen(
                quote = quote,
                onNavigateBack = {
                    navHostController.navigateUp()
                }
            )
        }

        composable<Screen.RandomQuote> {
            RandomQuoteScreen(
                onNavigateBack = {
                    navHostController.navigateUp()
                }
            )
        }

        composable<Screen.QuoteOfTheDay> {
            QuoteOfTheDayScreen()
        }

        composable<Screen.Home> {
            HomeScreen(
                modifier = Modifier.fillMaxSize(),
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
