package mende273.quoteskmp.ui.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.local.LocalRepository

class QuoteDetailViewModel(
    private val localRepository: LocalRepository
) : ViewModel() {

    private var quote: Quote? = null

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> get() = _isFavorite

    fun init(quote: Quote) {
        this.quote = quote
        checkIsFavorite()
    }

    private fun checkIsFavorite() {
        viewModelScope.launch {
            quote?.let {
                localRepository.getFavouriteQuote(it.id)
                    .collectLatest { quote ->
                        _isFavorite.update { quote != null }
                    }
            }
        }
    }

    fun toggleFavourite() {
        viewModelScope.launch {
            quote?.let {
                when (_isFavorite.value) {
                    true -> localRepository.removeFavouriteQuote(it)

                    false -> localRepository.addFavouriteQuote(it)
                }
            }
        }
    }
}
