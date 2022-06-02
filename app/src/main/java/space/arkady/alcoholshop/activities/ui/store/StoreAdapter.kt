package space.arkady.alcoholshop.activities.ui.store

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.item_beer.view.*
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.models.Drink
import javax.inject.Inject

class StoreAdapter(
    private val context: Context,
    private val drinks: List<Drink>
) : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {

    inner class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_beer,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val drink = drinks[position]
        holder.beer.text = drink.beer
        holder.style.text = drink.style
        holder.brand.text = drink.brand
        holder.fermentation.text = drink.fermentation
        holder.region.text = drink.region
        holder.producer.text = drink.producer
        holder.strength.text = drink.strength
        holder.volume.text = drink.volume
        holder.price.text = drink.price

        Glide.with(context).load(drink.imageUri).into(holder.imageBeer)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

}