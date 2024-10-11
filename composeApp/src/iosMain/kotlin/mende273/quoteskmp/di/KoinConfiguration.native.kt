package mende273.quoteskmp.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import mende273.quoteskmp.database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun databaseDriverPlatformModule(): Module = module {
    single<SqlDriver> {
        DatabaseDriverFactory().createDriver()
    }
}

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "quotes.db")
    }
}