package space.arkady.alcoholshop.domain.usecases

import space.arkady.alcoholshop.domain.models.Beer

interface BeerUsecase {
    suspend fun getBeers(): List<Beer>
}