package space.arkady.alcoholshop.domain.usecases

import space.arkady.alcoholshop.domain.datastore.RemoteDataStore
import space.arkady.alcoholshop.domain.models.Beer

internal class BeerUsecaseImpl(
    private val remoteDataStore: RemoteDataStore
) : BeerUsecase {
    override suspend fun getBeers(): List<Beer> {
        return remoteDataStore.getBeers()
    }
}