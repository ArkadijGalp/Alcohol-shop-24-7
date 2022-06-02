package space.arkady.alcoholshop.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Drink(
    val beer: String = "",
    val brand: String = "",
    val fermentation: String = "",
    val imageUri: String = "",
    val price: String = "",
    val producer: String = "",
    val region: String = "",
    val strength: String = "",
    val style: String = "",
    val volume: String = ""
)
