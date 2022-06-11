package space.arkady.alcoholshop.activities.ui.store.interactors

import space.arkady.alcoholshop.activities.ui.store.adapter.FirebaseDatabaseManagerImpl
import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.activities.ui.store.repository.BeerRepository
import space.arkady.alcoholshop.utils.Constants
import javax.inject.Inject

class BeerInteractorImpl @Inject constructor(
    private val beerRepository: BeerRepository) :
    BeerInteractor {
    override suspend fun getBeers(): List<Beer> {
        val getBeerList = beerRepository.getBeers()
        return getBeerList?.map { documentSnapshot ->
            Beer(
                beer = documentSnapshot.get(Constants.BEER).toString(),
                style = documentSnapshot.get(Constants.STYLE).toString(),
                strength = documentSnapshot.get(Constants.STRENGTH).toString(),
                imageUri = documentSnapshot.get(Constants.IMAGE_URI).toString(),
                brand = documentSnapshot.get(Constants.BEER).toString(),
                fermentation = documentSnapshot.get(Constants.FERMENTATION).toString(),
                volume = documentSnapshot.get(Constants.VOLUME).toString(),
                region = documentSnapshot.get(Constants.REGION).toString(),
                producer = documentSnapshot.get(Constants.PRODUCER).toString(),
                price = documentSnapshot.get(Constants.PRICE).toString()
            )
        }
            ?: emptyList()
    }
}