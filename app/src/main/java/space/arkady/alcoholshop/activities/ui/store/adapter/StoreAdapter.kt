package space.arkady.alcoholshop.activities.ui.store.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.withContext
import space.arkady.alcoholshop.databinding.ItemBeerBinding
import space.arkady.alcoholshop.activities.ui.store.models.Beer

class StoreAdapter(

) : RecyclerView.Adapter<StoreViewHolder>() {
    private var beers: List<Beer> = emptyList()

    //Вынести вьюхолдер в отдельный файл
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val drink = beers[position]
        holder.bindItem(drink)
    }

    override fun getItemCount(): Int {
        return beers.size
    }

    fun bindItem(items: List<Beer>) {
        beers = items
        notifyDataSetChanged()
    }
}
