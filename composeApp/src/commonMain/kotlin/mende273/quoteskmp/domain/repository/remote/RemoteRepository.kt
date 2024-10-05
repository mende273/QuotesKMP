package mende273.quoteskmp.domain.repository.remote

import mende273.quoteskmp.domain.model.Quote

interface RemoteRepository {
    suspend fun getQuotes(): Result<List<Quote>>
    suspend fun getRandomQuote(): Result<Quote>
    suspend fun getQuoteOfTheDay(): Result<Quote>
}
