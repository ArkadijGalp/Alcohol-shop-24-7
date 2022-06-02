package space.arkady.alcoholshop.activities

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_store.*
import kotlinx.android.synthetic.main.item_beer.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.activities.ui.store.StoreAdapter
import space.arkady.alcoholshop.databinding.ActivityDashBoardBinding
import space.arkady.alcoholshop.models.Drink
import kotlin.Exception

class DashBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@DashBoardActivity)
        }
        fetchData()
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_dash_board)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_store, R.id.navigation_shopping_cart, R.id.navigation_payment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    private fun fetchData() {
        FirebaseFirestore.getInstance()
            .collection("drinks")
            .get()
            .addOnSuccessListener { drinks ->
                for (drink in drinks) {
                    val beer = drinks.toObjects(Drink::class.java)
                    binding.recycler.adapter = StoreAdapter(this, beer)
                }
            }.addOnFailureListener {
                Toast.makeText(this, "An error has occurred", Toast.LENGTH_SHORT).show()
            }
    }

}