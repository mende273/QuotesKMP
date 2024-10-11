package mende273.quoteskmp.data.repository.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import mende273.quoteskmp.data.mapper.mapToQuote
import mende273.quoteskmp.data.mapper.mapToQuoteEntity
import mende273.quoteskmp.data.mapper.mapToQuotes
import mende273.quoteskmp.data.source.local.LocalDataSource
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.local.LocalRepository

class LocalRepositoryImpl(private val localDataSource: LocalDataSource) : LocalRepository {

    override suspend fun getAllFavouriteQuotes(): Flow<List<Quote>> =
        withContext(Dispatchers.IO) {
            localDataSource
                .selectAll()
                .mapToQuotes()
        }

    override suspend fun getFavouriteQuote(id: Long): Flow<Quote?> =
        withContext(Dispatchers.IO) {
            localDataSource
                .selectById(id)
                .mapToQuote()
        }

    override suspend fun addFavouriteQuote(quote: Quote) {
        withContext(Dispatchers.IO) {
            localDataSource.insert(quote.mapToQuoteEntity())
        }
    }

    override suspend fun removeFavouriteQuote(quote: Quote) {
        withContext(Dispatchers.IO) {
            localDataSource.delete(quote.id)
        }
    }
}
