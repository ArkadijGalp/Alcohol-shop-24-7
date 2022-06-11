package space.arkady.alcoholshop.activities.ui.store.interactors

import space.arkady.alcoholshop.activities.ui.store.models.Beer

interface BeerInteractor {
    suspend fun getBeers(): List<Beer>
}