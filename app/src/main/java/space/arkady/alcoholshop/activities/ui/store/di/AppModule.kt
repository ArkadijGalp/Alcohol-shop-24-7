package space.arkady.alcoholshop.activities.ui.store.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.arkady.alcoholshop.activities.ui.store.repository.BeerRepositoryImpl
import space.arkady.alcoholshop.activities.ui.store.repository.BeerRepository
import space.arkady.alcoholshop.activities.ui.store.usecases.GetBeers
import space.arkady.alcoholshop.activities.ui.store.usecases.Usecases
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
        beersReference: CollectionReference
    ): BeerRepository = BeerRepositoryImpl(beersReference)

    @Provides
    fun provideUsecases(
        repository: BeerRepository
    ) = Usecases(getBeers = GetBeers(repository))
}