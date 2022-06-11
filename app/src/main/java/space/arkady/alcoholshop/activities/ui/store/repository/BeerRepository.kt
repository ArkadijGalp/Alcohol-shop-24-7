package space.arkady.alcoholshop.activities.ui.store.repository

import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.flow.Flow
import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.activities.ui.store.models.Response

interface BeerRepository {
    suspend fun getBeers(): QuerySnapshot?
}