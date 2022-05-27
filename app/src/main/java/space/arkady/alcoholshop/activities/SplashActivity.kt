package space.arkady.alcoholshop.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import space.arkady.alcoholshop.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, 3000)

       /* val typeface: Typeface = Typeface.createFromAsset(assets, "quigley.TTF")
        tv_app_name.typeface = typeface*/
    }
}