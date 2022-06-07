package space.arkady.alcoholshop.activities.ui.store.views

import space.arkady.alcoholshop.domain.models.Beer

sealed class MainViewState {

    object Loading : MainViewState() {

        data class Success(
            val data: List<Beer>
        ) : MainViewState()

        data class Failure(
            val errorMessage: String
        ) : MainViewState()
    }
}