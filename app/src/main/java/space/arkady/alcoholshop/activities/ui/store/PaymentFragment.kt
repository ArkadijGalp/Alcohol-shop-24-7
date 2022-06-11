package space.arkady.alcoholshop.activities.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.activities.ui.store.adapter.StoreAdapter
import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.activities.ui.store.views.MainViewModel

@AndroidEntryPoint
class PaymentFragment(): Fragment(R.layout.fragment_payment) {

    private val mainViewModel: MainViewModel by viewModels()

    companion object {
        const val TAG = "PaymentFragment"
        fun newInstance() = PaymentFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}