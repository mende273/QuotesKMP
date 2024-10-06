package mende273.quoteskmp.data.source.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse

class RemoteDataSource(private val client: HttpClient) {

    suspend fun getQuotes(): HttpResponse =
        client.get {
            url("quotes")
        }

    suspend fun getRandomQuote(): HttpResponse =
        client.get {
            url("random")
        }

    suspend fun getQuoteOfTheDay(): HttpResponse =
        client.get {
            url("today")
        }
}