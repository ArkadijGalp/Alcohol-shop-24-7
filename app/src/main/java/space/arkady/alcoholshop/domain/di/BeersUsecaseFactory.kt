package space.arkady.alcoholshop.domain.di

import com.google.firebase.firestore.FirebaseFirestore
import space.arkady.alcoholshop.domain.datastore.RemoteDataStore
import space.arkady.alcoholshop.domain.usecases.BeerUsecaseImpl
import space.arkady.alcoholshop.domain.usecases.BeerUsecase

object BeersUsecaseFactory {
    fun create(remoteDataStore: RemoteDataStore): BeerUsecase {
        return BeerUsecaseImpl(remoteDataStore)
    }
}