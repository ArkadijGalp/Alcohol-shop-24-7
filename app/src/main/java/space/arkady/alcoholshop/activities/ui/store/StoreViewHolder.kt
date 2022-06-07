package space.arkady.alcoholshop.activities.ui.store

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.ktx.firestoreSettings
import kotlinx.android.synthetic.main.item_beer.view.*
import kotlinx.coroutines.withContext
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.databinding.ItemBeerBinding
import space.arkady.alcoholshop.domain.models.Beer

class StoreViewHolder(private val binding: ItemBeerBinding, private val context: Context) :
    RecyclerView.ViewHolder(binding.root) {

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
            Glide.with(context).load(item.imageUri).into(imageBeer)
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