package mende273.quoteskmp.ui.feature.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import mende273.quoteskmp.data.mapper.toUiState
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.local.LocalRepository
import mende273.quoteskmp.ui.common.state.UIState

class FavouritesViewModel(
    private val localRepository: LocalRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UIState<List<Quote>>> =
        MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState<List<Quote>>> = _uiState

    init {
        viewModelScope.launch { getAllFavourites() }
    }

    private suspend fun getAllFavourites() {
        localRepository.getAllFavouriteQuotes().collectLatest {
            _uiState.value = it.toUiState()
        }
    }
}
