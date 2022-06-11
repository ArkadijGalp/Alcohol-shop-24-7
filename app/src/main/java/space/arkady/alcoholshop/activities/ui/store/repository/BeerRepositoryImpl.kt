package space.arkady.alcoholshop.activities.ui.store.repository

import com.google.firebase.firestore.QuerySnapshot
import space.arkady.alcoholshop.activities.ui.store.adapter.FirebaseDatabaseManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerRepositoryImpl @Inject constructor(
    private val firebaseDatabaseManager: FirebaseDatabaseManager
) : BeerRepository {

    override suspend fun getBeers(): QuerySnapshot? {
        return firebaseDatabaseManager.getBeers()
    }
}

