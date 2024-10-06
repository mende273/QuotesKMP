package mende273.quoteskmp.data.repository.remote

import io.ktor.client.call.body
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import mende273.quoteskmp.data.mapper.mapToQuotes
import mende273.quoteskmp.data.model.dto.QuoteDTO
import mende273.quoteskmp.data.source.remote.RemoteDataSource
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.remote.RemoteRepository

class RemoteRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher
) :
    RemoteRepository {

    override suspend fun getQuotes(): Result<List<Quote>> =
        withContext(ioDispatcher) {
            runCatching {
                remoteDataSource
                    .getQuotes()
                    .body<List<QuoteDTO>>()
                    .mapToQuotes()
            }
        }

    override suspend fun getRandomQuote(): Result<Quote> =
        withContext(ioDispatcher) {
            runCatching {
                remoteDataSource
                    .getRandomQuote()
                    .body<List<QuoteDTO>>()
                    .mapToQuotes()
                    .first()
            }
        }

    override suspend fun getQuoteOfTheDay(): Result<Quote> =
        withContext(ioDispatcher) {
            runCatching {
                remoteDataSource
                    .getQuoteOfTheDay()
                    .body<List<QuoteDTO>>()
                    .mapToQuotes()
                    .first()
            }
        }
}
