package mende273.quoteskmp.di

import mende273.quoteskmp.ui.feature.detail.QuoteDetailViewModel
import mende273.quoteskmp.ui.feature.favourites.FavouritesViewModel
import mende273.quoteskmp.ui.feature.home.HomeViewModel
import mende273.quoteskmp.ui.feature.random.RandomQuoteViewModel
import mende273.quoteskmp.ui.feature.today.QuoteOfTheDayViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { QuoteDetailViewModel() }
    viewModel { FavouritesViewModel() }
    viewModel { RandomQuoteViewModel() }
    viewModel { QuoteOfTheDayViewModel() }
}