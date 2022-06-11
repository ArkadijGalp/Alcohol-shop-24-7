package space.arkady.alcoholshop.activities.ui.store.repository

import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import space.arkady.alcoholshop.activities.ui.store.adapter.StoreAdapter
import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.activities.ui.store.models.Response
import space.arkady.alcoholshop.activities.ui.store.usecases.GetBeers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerRepositoryImpl @Inject constructor(
    private val beerRef: CollectionReference
) : BeerRepository {

    override fun getBeersFromFirestore() = callbackFlow {
        val snapshotListener = beerRef.addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val beers = snapshot.toObjects(Beer::class.java)
                Response.Success(beers)
            } else {
                Response.Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}

