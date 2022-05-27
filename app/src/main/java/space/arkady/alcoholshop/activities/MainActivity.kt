package space.arkady.alcoholshop.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.utils.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        analytics = Firebase.analytics

        val sharedPreferences =
            getSharedPreferences(Constants.MYALCOHOLSHOP_PREFS, Context.MODE_PRIVATE)
        val username = sharedPreferences.getString(Constants.LOGGED_IN_USERNAME, "")!!
        tv_main.text = "The logged user is $username."

    }
}