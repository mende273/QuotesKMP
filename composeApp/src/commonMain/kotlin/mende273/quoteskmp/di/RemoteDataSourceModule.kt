package mende273.quoteskmp.di

import mende273.quoteskmp.data.source.remote.RemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { RemoteDataSource() }
}
