package mende273.quoteskmp.data.repository.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
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
                remoteDataSource.getQuotes().map { Quote(it.c ?: 0, it.q, it.a) }
            }
        }

    override suspend fun getRandomQuote(): Result<Quote> =
        withContext(ioDispatcher) {
            runCatching {
                remoteDataSource.getRandomQuote().map { Quote(it.c ?: 0, it.q, it.a) }.first()
            }
        }

    override suspend fun getQuoteOfTheDay(): Result<Quote> =
        withContext(ioDispatcher) {
            runCatching {
                remoteDataSource.getQuoteOfTheDay().map { Quote(it.c ?: 0, it.q, it.a) }.first()
            }
        }
}
