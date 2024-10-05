package mende273.quoteskmp.data.repository.remote

import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.remote.RemoteRepository

class RemoteRepositoryImpl :
    RemoteRepository {

    override suspend fun getQuotes(): Result<List<Quote>> =
        Result.success(
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

    override suspend fun getRandomQuote(): Result<Quote> =
        Result.success(
            Quote(
                1,
                "Everything comes to him who hustles while he waits.",
                "Thomas Edison"
            )
        )

    override suspend fun getQuoteOfTheDay(): Result<Quote> =
        Result.success(
            Quote(
                1,
                "Everything comes to him who hustles while he waits.",
                "Thomas Edison"
            )
        )
}
