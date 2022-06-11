package space.arkady.alcoholshop.activities.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.activities.ui.store.adapter.StoreAdapter
import space.arkady.alcoholshop.activities.ui.store.views.MainViewModel
import space.arkady.alcoholshop.databinding.FragmentShoppingCartBinding

@AndroidEntryPoint
class ShoppingCartFragment() : Fragment(R.layout.fragment_shopping_cart) {

    private lateinit var binding: FragmentShoppingCartBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter: StoreAdapter = StoreAdapter()


    companion object {
        const val TAG = "ShoppingCartFragment"
        fun newInstance() = ShoppingCartFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoppingCartBinding.inflate(layoutInflater)
        return binding.root
        /*return inflater.inflate(R.layout.item_beer, container, false)*/

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        viewModel.beerLiveData.observe(viewLifecycleOwner) {
            binding.recycler.adapter = adapter
        }
    }

    private fun setupViews() {
        with(binding) {
            recycler.setHasFixedSize(true)
            recycler.adapter = adapter
        }
    }
}
