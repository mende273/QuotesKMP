package mende273.quoteskmp.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import mende273.quoteskmp.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun databaseDriverPlatformModule() = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
}

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = AppDatabase.Schema,
            context = context,
            name = "Quotes.db"
        )
    }
}