package space.arkady.alcoholshop.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun FragmentActivity.openFragment(containerId: Int, fragment: Fragment, tag: String) {
    supportFragmentManager.beginTransaction().replace(containerId, fragment, tag)
        .addToBackStack(tag).commit()
}
