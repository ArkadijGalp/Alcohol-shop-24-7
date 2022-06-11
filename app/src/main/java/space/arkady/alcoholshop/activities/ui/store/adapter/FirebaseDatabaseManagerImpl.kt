package space.arkady.alcoholshop.activities.ui.store.adapter

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import space.arkady.alcoholshop.utils.await
import javax.inject.Inject

class FirebaseDatabaseManagerImpl : FirebaseDatabaseManager {
    override suspend fun getBeers(): QuerySnapshot? {
        return withContext(Dispatchers.IO) {
            return@withContext FirebaseFirestore.getInstance()
                .collection("drinks")
                .get()
                .await()
        }
    }
}