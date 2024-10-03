package mende273.quoteskmp.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kotlinx.serialization.Serializable
import mende273.quoteskmp.domain.model.Quote

sealed interface Screen {

    @Serializable
    data object Home : Screen

    @Serializable
    data object Favourites : Screen

    @Serializable
    data object RandomQuote : Screen

    @Serializable
    data object QuoteOfTheDay : Screen


    //todo workaround, CMP currently not supporting custom safe NavType
    @Serializable
    data object QuoteDetail : Screen {

        const val ARGUMENT_ID = "id"
        const val ARGUMENT_CONTENT = "content"
        const val ARGUMENT_AUTHOR = "author"

        const val ROUTE: String =
            "quote_detail/{$ARGUMENT_ID}/{$ARGUMENT_CONTENT}/{$ARGUMENT_AUTHOR}"

        fun getNavArguments(): List<NamedNavArgument> {
            return listOf(
                navArgument(ARGUMENT_ID) { type = NavType.IntType },
                navArgument(ARGUMENT_CONTENT) { type = NavType.StringType },
                navArgument(ARGUMENT_AUTHOR) { type = NavType.StringType }
            )
        }

        fun getRoute(quote: Quote):String{
           return "quote_detail/${quote.id}/${quote.content}/${quote.author}"
        }
    }
}
