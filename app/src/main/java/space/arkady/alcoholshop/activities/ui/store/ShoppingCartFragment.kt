package space.arkady.alcoholshop.activities.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_shopping_cart.*
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.activities.ui.store.adapter.StoreAdapter
import space.arkady.alcoholshop.activities.ui.store.views.MainViewModel
import space.arkady.alcoholshop.databinding.FragmentShoppingCartBinding

@AndroidEntryPoint
class ShoppingCartFragment() : Fragment(R.layout.fragment_shopping_cart) {

    private val viewbinding: FragmentShoppingCartBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()
    private val adapter: StoreAdapter by lazy { StoreAdapter()}
    private val recycler by lazy { view?.findViewById<RecyclerView>(R.id.recycler)}


    companion object {
        const val TAG = "ShoppingCartFragment"
        fun newInstance() = ShoppingCartFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        recycler?.adapter = adapter
        viewModel.beerLiveData.observe(viewLifecycleOwner) {
            adapter.bindItem(it)
        }
    }
}
