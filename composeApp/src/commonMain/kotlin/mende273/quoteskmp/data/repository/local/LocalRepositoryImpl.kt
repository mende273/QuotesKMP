package mende273.quoteskmp.data.repository.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.local.LocalRepository

class LocalRepositoryImpl : LocalRepository {

    override suspend fun getAllFavouriteQuotes(): Flow<List<Quote>> =
        flow {
            emit(listOf(
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
            ))
        }

    override suspend fun getFavouriteQuote(id: Int): Flow<Quote?> =
        flow {
            emit(Quote(
                1,
                "Everything comes to him who hustles while he waits.",
                "Thomas Edison"
            ))
        }

    override suspend fun addFavouriteQuote(quote: Quote) {
        //
    }

    override suspend fun removeFavouriteQuote(quote: Quote) {
        //
    }
}
