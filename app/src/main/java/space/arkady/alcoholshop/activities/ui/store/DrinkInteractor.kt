package space.arkady.alcoholshop.activities.ui.store

import space.arkady.alcoholshop.domain.models.Beer

interface DrinkInteractor {
    fun getDrink(): List<Beer>
}