package mende273.quoteskmp.data.source.remote

import mende273.quoteskmp.data.model.dto.QuoteDTO

class RemoteDataSource {

    suspend fun getQuotes(): List<QuoteDTO> {
        return listOf(
            QuoteDTO(
                c = 1,
                q = "Everything comes to him who hustles while he waits.",
                a = "Thomas Edison"
            ),
            QuoteDTO(
                c = 2,
                q = "Change in all things is sweet.",
                a = "Aristotle"
            ),
            QuoteDTO(
                c = 3,
                q = "I never think of the future - it comes soon enough.",
                a = "Albert Einstein"
            ),
            QuoteDTO(
                c = 4,
                q = "As a cure for worrying, work is better than whisky.",
                a = "Thomas Edison"
            )
        )
    }

    suspend fun getRandomQuote(): List<QuoteDTO> {
        return listOf(
            QuoteDTO(
                1,
                "Everything comes to him who hustles while he waits.",
                "Thomas Edison"
            )
        )
    }

    suspend fun getQuoteOfTheDay(): List<QuoteDTO> {
        return listOf(
            QuoteDTO(
                1,
                "Everything comes to him who hustles while he waits.",
                "Thomas Edison"
            )
        )
    }
}