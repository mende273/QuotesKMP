package mende273.quoteskmp.di

import mende273.quoteskmp.data.repository.remote.RemoteRepositoryImpl
import mende273.quoteskmp.domain.repository.remote.RemoteRepository
import org.koin.dsl.module

val remoteRepositoryModule = module {
    single<RemoteRepository> { RemoteRepositoryImpl(get(), get()) }
}
