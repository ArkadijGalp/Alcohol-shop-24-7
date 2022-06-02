package space.arkady.alcoholshop.activities.ui.store

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.item_beer.*
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.databinding.FragmentStoreBinding
import space.arkady.alcoholshop.models.Drink

class StoreFragment() : Fragment() {

    private var _binding: FragmentStoreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this).get(StoreViewModel::class.java)

        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        val root: View = binding.root

/*        val textView: TextView = binding.
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
