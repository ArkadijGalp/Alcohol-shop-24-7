package space.arkady.alcoholshop.firestore

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import space.arkady.alcoholshop.activities.LoginActivity
import space.arkady.alcoholshop.activities.RegisterActivity
import space.arkady.alcoholshop.models.User
import space.arkady.alcoholshop.utils.Constants

class FirestoreClass {
    private val mFirestore = FirebaseFirestore.getInstance()

    fun registerUser(activity: RegisterActivity, userInfo: User) {
        mFirestore.collection(Constants.USERS).document(userInfo.id)
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegistrationSuccess()
            }.addOnFailureListener { e ->
                activity.hideProgressDialog()
                Log.e(activity.javaClass.simpleName, "Error while registration", e)
            }

    }

    fun getCurrentUserId(): String {

        //An instance of current user related to FirebaseAuthentication
        val currentUser = FirebaseAuth.getInstance().currentUser

        var currentUserId = ""
        if (currentUser != null) {
            currentUserId = currentUser.uid
        }
        return currentUserId
    }

    fun getUserDetail(activity: Activity) {
        mFirestore.collection(Constants.USERS).document(getCurrentUserId()).get()
            .addOnSuccessListener { document ->
                Log.i(activity.javaClass.simpleName, document.toString())

                val user = document.toObject(User::class.java)!!

                val sharedPreferences = activity.getSharedPreferences(
                    Constants.MYALCOHOLSHOP_PREFS,
                    Context.MODE_PRIVATE
                )
                //Key = Logged in Username!
                // Value = firstname + lastname of the user
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString(
                    Constants.LOGGED_IN_USERNAME, "${user.firstName} ${user.lastName}"
                )
                editor.apply()
//Next is result of login activity
                when (activity) {
                    is LoginActivity -> {
                        activity.userLoggedInSuccess(user)
                    }
                }
                //End
            }.addOnFailureListener { error ->
                when (activity) {
                    is LoginActivity -> {
                        activity.hideProgressDialog()
                    }
                }
                Log.e(activity.javaClass.simpleName, "Failed attempt to Login")
            }
    }
}