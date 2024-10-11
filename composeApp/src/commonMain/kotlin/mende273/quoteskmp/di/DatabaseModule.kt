package mende273.quoteskmp.di

import app.cash.sqldelight.db.SqlDriver
import mende273.quoteskmp.data.source.local.LocalDataSource
import mende273.quoteskmp.database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

expect fun databaseDriverPlatformModule(): Module

val databaseModule = module {
    single { createDatabase(driver = get()) }
    single { LocalDataSource(database = get(), ioDispatcher = get()) }
}

private fun createDatabase(driver: SqlDriver): AppDatabase {
    return AppDatabase(driver)
}