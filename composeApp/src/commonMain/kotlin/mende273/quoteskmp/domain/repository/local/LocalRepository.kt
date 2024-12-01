package mende273.quoteskmp.domain.repository.local

import kotlinx.coroutines.flow.Flow
import mende273.quoteskmp.domain.model.Quote

interface LocalRepository {

    fun getAllFavouriteQuotes(): Flow<List<Quote>>
    fun getFavouriteQuote(id: Long): Flow<Quote?>
    suspend fun addFavouriteQuote(quote: Quote)
    suspend fun removeFavouriteQuote(quote: Quote)
}
