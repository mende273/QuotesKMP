package mende273.quoteskmp.data.repository.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import mende273.quoteskmp.data.mapper.mapToQuote
import mende273.quoteskmp.data.mapper.mapToQuoteEntity
import mende273.quoteskmp.data.mapper.mapToQuotes
import mende273.quoteskmp.data.source.local.LocalDataSource
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.local.LocalRepository

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : LocalRepository {

    override fun getAllFavouriteQuotes(): Flow<List<Quote>> =
        localDataSource.selectAll().mapToQuotes()

    override fun getFavouriteQuote(id: Long): Flow<Quote?> =
        localDataSource.selectById(id).mapToQuote()

    override suspend fun addFavouriteQuote(quote: Quote) {
        withContext(ioDispatcher) {
            localDataSource.insert(quote.mapToQuoteEntity())
        }
    }

    override suspend fun removeFavouriteQuote(quote: Quote) {
        withContext(ioDispatcher) {
            localDataSource.delete(quote.id)
        }
    }
}
