package space.arkady.alcoholshop.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.item_beer.*
import space.arkady.alcoholshop.activities.ui.store.StoreAdapter
import space.arkady.alcoholshop.activities.ui.store.views.MainViewModel
import space.arkady.alcoholshop.databinding.ActivityDashBoardBinding
import space.arkady.alcoholshop.domain.models.Beer

class DashBoardActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var binding: ActivityDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@DashBoardActivity)
        }

        fetchData()
    }


/*        openFragment(
            R.id.container,
            ShoppingCartFragment.newInstance(),
            ShoppingCartFragment.TAG
        )
    }*/

/*    private fun setupViews() {
        with(binding) {
            recycler.adapter = adapter
        }
    }*/

    fun fetchData() {
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
    }
}

