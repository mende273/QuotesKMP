package mende273.quoteskmp.ui.feature.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.state.UIState

class FavouritesViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<UIState<List<Quote>>> =
        MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState<List<Quote>>> = _uiState

    init {
        viewModelScope.launch { getAllFavourites() }
    }

    private suspend fun getAllFavourites() {
        _uiState.value = UIState.SuccessWithData(
            listOf(
                Quote(
                    id = 1,
                    content = "Everything comes to him who hustles while he waits.",
                    author = "Thomas Edison"
                ),
                Quote(
                    id = 2,
                    content = "Change in all things is sweet.",
                    author = "Aristotle"
                ),
                Quote(
                    id = 3,
                    content = "I never think of the future - it comes soon enough.",
                    author = "Albert Einstein"
                ),
                Quote(
                    id = 4,
                    content = "As a cure for worrying, work is better than whisky.",
                    author = "Thomas Edison"
                )
            )
        )
    }
}
