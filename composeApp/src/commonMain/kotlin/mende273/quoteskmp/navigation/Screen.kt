package mende273.quoteskmp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object Home : Screen

    @Serializable
    data object Favourites : Screen

    @Serializable
    data object RandomQuote : Screen

    @Serializable
    data object QuoteOfTheDay : Screen

    @Serializable
    data class QuoteDetail(val id: Long, val content: String, val author: String)
}
