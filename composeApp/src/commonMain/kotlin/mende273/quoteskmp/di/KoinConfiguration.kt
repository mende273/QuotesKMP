package mende273.quoteskmp.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            viewModelModule,
            localRepositoryModule,
            remoteRepositoryModule,
            dispatchersModule,
            remoteDataSourceModule,
            networkModule,
            databaseModule,
            databaseDriverPlatformModule()
        )
    }