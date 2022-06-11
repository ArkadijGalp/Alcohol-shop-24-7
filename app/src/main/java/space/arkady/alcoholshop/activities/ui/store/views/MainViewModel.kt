package space.arkady.alcoholshop.activities.ui.store.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import space.arkady.alcoholshop.activities.ui.store.interactors.BeerInteractor
import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.activities.ui.store.models.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val beerInteractor: BeerInteractor

) : ViewModel() {

    val beerLiveData: LiveData<List<Beer>> get() = _beerLiveData
    private val _beerLiveData = MutableLiveData<List<Beer>>()

    init {
        getBeers()
    }

    private fun getBeers() {
        viewModelScope.launch {
            _beerLiveData.postValue(beerInteractor.getBeers())
        }


/*    private val _mainViewStateFlow: MutableStateFlow<MainViewState> =
        MutableStateFlow(MainViewState.Loading)
    val mainViewStateFlow: StateFlow<MainViewState> = _mainViewStateFlow.asStateFlow()

    private fun getBeers() {
        viewModelScope.launch {
            usecases.getBeers().collect { response ->
                _booksState.value = response
            }
        }
    }*/

/*    fun fetchProducts() = viewModelScope.launch(Dispatchers.IO) {
        _mainViewStateFlow.value = MainViewState.Loading
        kotlin.runCatching {
            usecases.()
        }.fold(
            onSuccess = { drinks ->
                _mainViewStateFlow.value = MainViewState.Success(drinks)
            }, onFailure = { error ->
                _mainViewStateFlow.value =
                    MainViewState.Failure(error.localizedMessage ?: "Something is wrong")
            }
        )
    }*/
/*        FirebaseFirestore.getInstance()
            .collection("drinks")
            .get()
            .addOnSuccessListener { drinks ->
                for (drink in drinks) {
                    val beer = drinks.toObjects(Beer::class.java)
                }
            }.addOnFailureListener {
                Toast.makeText(this, "An error has occurred", Toast.LENGTH_SHORT).show()
            }*/
    }
}
