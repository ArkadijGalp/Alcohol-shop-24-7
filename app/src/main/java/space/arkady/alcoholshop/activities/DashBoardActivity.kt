package space.arkady.alcoholshop.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.activities.ui.store.ShoppingCartFragment
import space.arkady.alcoholshop.activities.ui.store.adapter.StoreAdapter
import space.arkady.alcoholshop.activities.ui.store.views.MainViewModel
import space.arkady.alcoholshop.databinding.ActivityDashBoardBinding
import space.arkady.alcoholshop.activities.ui.store.models.Beer
import space.arkady.alcoholshop.utils.openFragment

@AndroidEntryPoint
class DashBoardActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(
            R.id.container,
            ShoppingCartFragment.newInstance(),
            ShoppingCartFragment.TAG
        )

/*        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@DashBoardActivity)*/
        }
    }




/*    private fun setupViews() {
        with(binding) {
            recycler.adapter = adapter
        }
    }*/

/*    fun fetchData() {
        FirebaseFirestore.getInstance()
            .collection("drinks")
            .get()
            .addOnSuccessListener { beers ->
                for (beer in beers) {
                    val beer = beers.toObjects(Beer::class.java)
                    binding.recycler.adapter = StoreAdapter(this, beer)
                }
            }.addOnFailureListener {
                Toast.makeText(this, "An error has occurred", Toast.LENGTH_SHORT).show()
            }
    }*/
