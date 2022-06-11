package space.arkady.alcoholshop.utils

import space.arkady.alcoholshop.activities.ui.store.models.Beer

internal fun Beer.toDomainProduct(): Beer {
    return Beer(
        price = price,
        style = style,
        brand = brand,
        fermentation = fermentation,
        strength = strength,
        producer = producer,
        beer = beer,
        region = region,
        imageUri = imageUri,
        volume = volume
    )
}