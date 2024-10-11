package mende273.quoteskmp.data.mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mende273.quoteskmp.domain.model.Quote
import mende273quoteskmpdatabase.QuoteEntity

fun Flow<List<QuoteEntity>>.mapToQuotes(): Flow<List<Quote>> {
    return this.map { items ->
        items.map {
            Quote(id = it.id, content = it.content, author = it.author)
        }
    }
}

fun Flow<QuoteEntity?>.mapToQuote(): Flow<Quote?> {
    return this.map {
        it?.let {
            Quote(id = it.id, content = it.content, author = it.author)
        }
    }
}

fun Quote.mapToQuoteEntity(): QuoteEntity {
    return QuoteEntity(id, content, author)
}
