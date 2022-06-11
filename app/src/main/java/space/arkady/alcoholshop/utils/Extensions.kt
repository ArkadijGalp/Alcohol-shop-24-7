package space.arkady.alcoholshop.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.CancellationException
import kotlin.coroutines.resumeWithException

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun FragmentActivity.openFragment(containerId: Int, fragment: Fragment, tag: String) {
    supportFragmentManager.beginTransaction().replace(containerId, fragment, tag)
        .addToBackStack(tag).commit()
}

suspend fun <T> Task<T>.await(): T {
    if (isComplete) {
        val e = exception
        return if (e == null) {
            if (isCanceled) {
                throw CancellationException(
                    "Task $this was cancelled normally.")
            } else {
                result
            }
        } else {
            throw e
        }
    }

    return suspendCancellableCoroutine { cont ->
        addOnCompleteListener {
            val e = exception
            if (e == null) {
                if (isCanceled) cont.cancel()
                else cont.resume(result, onCancellation = null)
            } else {
                cont.resumeWithException(e)
            }
        }
    }
}
