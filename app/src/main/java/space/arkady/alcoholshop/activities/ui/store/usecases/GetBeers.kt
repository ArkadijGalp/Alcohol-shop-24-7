package space.arkady.alcoholshop.activities.ui.store.usecases

import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.activities.ui.store.repository.BeerRepository

class GetBeers(private val repo: BeerRepository) {

operator fun invoke() = repo.getBeersFromFirestore()
/*    suspend fun getBeers(): List<Beer>*/
}