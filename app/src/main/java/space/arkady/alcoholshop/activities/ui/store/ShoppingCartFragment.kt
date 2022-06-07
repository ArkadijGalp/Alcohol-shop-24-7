package space.arkady.alcoholshop.activities.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.activities.ui.store.views.MainViewModel
import space.arkady.alcoholshop.databinding.FragmentShoppingCartBinding
import space.arkady.alcoholshop.utils.openFragment

class ShoppingCartFragment() : Fragment(R.layout.fragment_shopping_cart) {

    private lateinit var binding: FragmentShoppingCartBinding
    private val mainViewModel: MainViewModel by viewModels()

    companion object {
        const val TAG = "ShoppingCartFragment"
        fun newInstance() = ShoppingCartFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.item_beer, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
