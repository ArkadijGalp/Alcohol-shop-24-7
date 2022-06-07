package space.arkady.alcoholshop.activities.ui.store.views

import android.widget.Toast
import androidx.lifecycle.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import space.arkady.alcoholshop.activities.ui.store.DrinkInteractor
import space.arkady.alcoholshop.activities.ui.store.StoreAdapter
import space.arkady.alcoholshop.domain.models.Beer
import space.arkady.alcoholshop.domain.usecases.BeerUsecase
import space.arkady.alcoholshop.utils.Constants

class MainViewModel(private val beerUsecase: BeerUsecase) : ViewModel() {

    val beerDB = Firebase.firestore
    private val drinksCollection = beerDB.collection(Constants.DRINKS_COLLECTION)

    val beerLiveData: LiveData<List<Beer>> get() = _beerLiveData
    private val _beerLiveData = MutableLiveData<List<Beer>>()

    private val _mainViewStateFlow: MutableStateFlow<MainViewState> =
        MutableStateFlow(MainViewState.Loading)
    val mainViewStateFlow: StateFlow<MainViewState> = _mainViewStateFlow.asStateFlow()

    fun fetchBeers() = viewModelScope.launch(Dispatchers.IO) {
        _mainViewStateFlow.value = MainViewState.Loading
        kotlin.runCatching {
            beerUsecase.getBeers()
        }.fold(
            onSuccess = { beers ->
                _mainViewStateFlow.value = MainViewState.Success(beers)
            },
            onFailure = { error ->
                _mainViewStateFlow.value =
                    MainViewState.Failure(error.localizedMessage ?: "Something went wrong")
            }
        )

    }


/*        FirebaseFirestore.getInstance()
            .collection("drinks")
            .get()
            .addOnSuccessListener { drinks ->
                for (drink in drinks) {
                    val beer = drinks.toObjects(Beer::class.java)
                    viewModelScope
                }
            }.addOnFailureListener {
                Toast.makeText(this, "An error has occurred", Toast.LENGTH_SHORT).show()
            }*/
}
