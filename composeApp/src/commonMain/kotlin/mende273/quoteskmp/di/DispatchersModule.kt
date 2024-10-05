package mende273.quoteskmp.di

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val dispatchersModule = module {
    single { Dispatchers.IO }
}