package space.arkady.alcoholshop.activities.ui.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.item_beer.*

class StoreViewModel : ViewModel() {

    var number = 0

    fun addNumber() {
        number++
    }
    fun decreaseNumber() {
        number--
    }
}