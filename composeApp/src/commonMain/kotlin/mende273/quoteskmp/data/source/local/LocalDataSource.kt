package mende273.quoteskmp.data.source.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOneOrNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mende273.quoteskmp.database.AppDatabase
import mende273quoteskmpdatabase.QuoteEntity

class LocalDataSource(private val database: AppDatabase) {

    private val query get() = database.quoteQueries

    fun selectAll(): Flow<List<QuoteEntity>> = query.selectAll().asFlow().map { it.executeAsList() }

    fun insert(quoteEntity: QuoteEntity) {
        query.insert(quoteEntity)
    }

    fun selectById(id: Long): Flow<QuoteEntity?> =
        query.selectById(id).asFlow().mapToOneOrNull(Dispatchers.IO)

    fun delete(id: Long) {
        query.delete(id)
    }
}