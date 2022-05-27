package space.arkady.alcoholshop.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.firestore.FirestoreClass
import space.arkady.alcoholshop.models.User

class LoginActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_forgot_password.setOnClickListener(this)
        btn_login.setOnClickListener(this)
        tv_register.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.tv_forgot_password -> {
                    val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_login -> {
                    loginRegisteredUser()
                }
                R.id.tv_register -> {
                    val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun validateLoginDetails(): Boolean {
        return when {
            TextUtils.isEmpty(editText_email.text.toString().trim() { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.error_msg_enter_email), true)
                false
            }
            TextUtils.isEmpty(et_password.text.toString().trim() { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.error_missing_password_field), true)
                false
            }
            else -> {
                showErrorSnackBar("Your details are valid.", false)
                true
            }
        }
    }

    private fun loginRegisteredUser() {

        if (validateLoginDetails()) {
            showProgressDialog(resources.getString(R.string.please_wait))

            val email = editText_email.text.toString().trim { it <= ' ' }
            val password = et_password.text.toString().trim { it <= ' ' }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        FirestoreClass().getUserDetail(this@LoginActivity)
                    } else {
                        hideProgressDialog()
                        showErrorSnackBar(task.exception!!.message.toString(), true)
                    }
                }
        }
    }

    fun userLoggedInSuccess(user: User) {
        hideProgressDialog()

        Log.i("First name: ", user.firstName)
        Log.i("Last name: ", user.lastName)
        Log.i("E-mail: ", user.email)

        if (user.profileCompiled == 0) {
            //If the user profile is incomplete - Use the UserProfileActivity
            val intent = Intent(this@LoginActivity, UserProfileActivity::class.java)
            startActivity(intent)
        } else {
            //Redirect to Main user screen(MainActivity) after login
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
        finish()
    }
}