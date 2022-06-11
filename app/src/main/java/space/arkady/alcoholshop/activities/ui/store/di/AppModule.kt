package space.arkady.alcoholshop.activities.ui.store.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.arkady.alcoholshop.activities.ui.store.adapter.FirebaseDatabaseManager
import space.arkady.alcoholshop.activities.ui.store.adapter.FirebaseDatabaseManagerImpl
import space.arkady.alcoholshop.activities.ui.store.interactors.BeerInteractor
import space.arkady.alcoholshop.activities.ui.store.interactors.BeerInteractorImpl
import space.arkady.alcoholshop.activities.ui.store.repository.BeerRepositoryImpl
import space.arkady.alcoholshop.activities.ui.store.repository.BeerRepository
import space.arkady.alcoholshop.utils.Constants

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideBeerReference(
        db: FirebaseFirestore
    ) = db.collection(Constants.DRINKS_COLLECTION)

    @Provides
    fun provideBeersRepository(
        beersReference: FirebaseDatabaseManager
    ): BeerRepository = BeerRepositoryImpl(beersReference)

    @Provides
    fun provideBeerInteractor(
        beerRepository: BeerRepository
    ): BeerInteractor = BeerInteractorImpl(beerRepository)

    @Provides
    fun provideFirebaseDatabaseManager(
    ): FirebaseDatabaseManager = FirebaseDatabaseManagerImpl()
}