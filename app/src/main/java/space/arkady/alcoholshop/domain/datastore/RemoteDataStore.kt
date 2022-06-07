package space.arkady.alcoholshop.domain.datastore

import space.arkady.alcoholshop.domain.models.Beer

interface RemoteDataStore {

    suspend fun getBeers(): List<Beer>
}