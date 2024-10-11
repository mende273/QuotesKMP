package mende273.quoteskmp.di

import mende273.quoteskmp.data.repository.local.LocalRepositoryImpl
import mende273.quoteskmp.domain.repository.local.LocalRepository
import org.koin.dsl.module

val localRepositoryModule = module {
    single<LocalRepository> { LocalRepositoryImpl(get()) }
}
