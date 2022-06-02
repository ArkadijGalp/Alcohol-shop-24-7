package space.arkady.alcoholshop.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import space.arkady.alcoholshop.firestore.FirestoreClass
import javax.inject.Singleton

@Module
@InstallIn(ServiceComponent::class)
object ServiceModule {


    @Singleton
    @Provides
    fun provideDrinkDatabase() = FirestoreClass()
}