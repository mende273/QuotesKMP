package mende273.quoteskmp.data.mapper

import mende273.quoteskmp.data.model.dto.QuoteDTO
import mende273.quoteskmp.domain.model.Quote

/*
fun Response<List<QuoteDTO>>.mapToQuotesList(): List<Quote> =
    this.body()?.mapToQuotes() ?: emptyList()
*/
private fun List<QuoteDTO>.mapToQuotes(): List<Quote> = this.map { it.mapToQuote() }

private fun QuoteDTO.mapToQuote(): Quote = Quote(
    id = this.c ?: 0,
    content = this.q,
    author = this.a
)
