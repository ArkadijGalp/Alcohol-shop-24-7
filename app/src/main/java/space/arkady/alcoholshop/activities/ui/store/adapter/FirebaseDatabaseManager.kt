package space.arkady.alcoholshop.activities.ui.store.adapter

import com.google.firebase.firestore.QuerySnapshot

interface FirebaseDatabaseManager {
    suspend fun getBeers(): QuerySnapshot?
}