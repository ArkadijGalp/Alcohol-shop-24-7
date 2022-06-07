package space.arkady.alcoholshop.domain.models

data class Beer(
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
