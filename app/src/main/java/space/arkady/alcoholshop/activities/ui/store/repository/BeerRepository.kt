package space.arkady.alcoholshop.activities.ui.store.repository

import kotlinx.coroutines.flow.Flow
import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.activities.ui.store.models.Response

interface BeerRepository {
    fun getBeersFromFirestore(): Flow<Response<List<Beer>>>
}