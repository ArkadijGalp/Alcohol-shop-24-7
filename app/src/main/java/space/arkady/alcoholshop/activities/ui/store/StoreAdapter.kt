package space.arkady.alcoholshop.activities.ui.store

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import space.arkady.alcoholshop.databinding.ItemBeerBinding
import space.arkady.alcoholshop.domain.models.Beer

class StoreAdapter(
    private val context: Context,
    private val drinks: List<Beer>

) : RecyclerView.Adapter<StoreViewHolder>() {
    private var beers: List<Beer> = emptyList()

    //Вынести вьюхолдер в отдельный файл
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StoreViewHolder(
            ItemBeerBinding.inflate(layoutInflater, parent, false)
        , context)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val drink = drinks[position]
        holder.bindItem(drink)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }
}
