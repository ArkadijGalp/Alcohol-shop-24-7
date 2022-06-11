package space.arkady.alcoholshop.activities.ui.store.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_beer.view.*
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.activities.ui.store.ShoppingCartFragment
import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.databinding.ItemBeerBinding

class StoreViewHolder(private val binding: ItemBeerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup) =
            StoreViewHolder(
                ItemBeerBinding.bind(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_beer, parent, false
                    )
                )
            )
    }


    fun bindItem(item: Beer) {
        with(binding) {
            tvBeer.text = item.beer
            tvStyle.text = item.style
            tvPrice.text = item.price
            tvVolume.text = item.volume
            tvStrength.text = item.strength
            tvProducer.text = item.producer
            tvRegion.text = item.region
            tvFermentation.text = item.fermentation
            tvBrand.text = item.brand
            Glide.with(binding.root.context).load(item.imageUri).into(imageBeer)

            addBeerButtonn.setOnClickListener {
                var number = amountOfBeersSelected.text.toString().toInt()
                number++
                amountOfBeersSelected.text = number.toString()
            }
            removeBeerButton.setOnClickListener {
                var number = amountOfBeersSelected.text.toString().toInt()
                number--
                if (number <= 0) {
                    number = 0
                }
                amountOfBeersSelected.text = number.toString()
            }
        }
    }

/*
    val beer: TextView = itemView.findViewById(R.id.tv_beer)
    val style: TextView = itemView.findViewById(R.id.tv_style)
    val brand: TextView = itemView.findViewById(R.id.tv_brand)
    val fermentation: TextView = itemView.findViewById(R.id.tv_fermentation)
    val region: TextView = itemView.findViewById(R.id.tv_region)
    val producer: TextView = itemView.findViewById(R.id.tv_producer)
    val strength: TextView = itemView.findViewById(R.id.tv_strength)
    val volume: TextView = itemView.findViewById(R.id.tv_volume)
    val price: TextView = itemView.findViewById(R.id.tv_price)
    val imageBeer: ImageView = itemView.findViewById(R.id.image_beer)
*/


}