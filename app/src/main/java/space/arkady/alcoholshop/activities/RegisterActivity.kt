package space.arkady.alcoholshop.activities

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*
import space.arkady.alcoholshop.R
import space.arkady.alcoholshop.firestore.FirestoreClass
import space.arkady.alcoholshop.models.User

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupActionbar()

        tv_login.setOnClickListener {
            onBackPressed()

        }
        btn_register.setOnClickListener {
            validateRegisterDetails()
            registerUser()
        }
    }

    private fun setupActionbar() {

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_blackarrowback_24)
        }
        toolbar_register_activity.setNavigationOnClickListener { onBackPressed() }
    }

    private fun validateRegisterDetails(): Boolean {

        return when {
            TextUtils.isEmpty(til_first_name.text.toString().trim() { it <= ' ' }) -> {
                showErrorSnackBar(
                    resources.getString(R.string.error_msg_enter_firstname),
                    errorMessage = true
                )
                false
            }

            TextUtils.isEmpty(
                til_last_name.text.toString()
                    .trim() { it <= ' ' }) || til_last_name.length() <= 3 -> {
                showErrorSnackBar(
                    resources.getString(R.string.error_msg_enter_lastname),
                    errorMessage = true
                )
                false
            }
            TextUtils.isEmpty(til_email.text.toString().trim() { it <= ' ' }) -> {
                showErrorSnackBar(
                    resources.getString(R.string.error_missing_email),
                    errorMessage = true
                )
                false
            }
            TextUtils.isEmpty(et_passwordRegister.text.toString().trim() { it <= ' ' }) -> {
                showErrorSnackBar(
                    resources.getString(R.string.error_missing_password_field),
                    errorMessage = true
                )
                false
            }
            TextUtils.isEmpty(confirm_password.text.toString().trim() { it <= ' ' }) -> {
                showErrorSnackBar(
                    resources.getString(R.string.error_confirm_password),
                    errorMessage = true
                )
                false
            }
            et_passwordRegister.text.toString()
                .trim() { it <= ' ' } != confirm_password.text.toString().trim() { it <= ' ' } -> {
                showErrorSnackBar(
                    resources.getString(R.string.error_message_password_and_confirmpassword_mismatch),
                    true
                )
                false
            }
            !cb_terms_and_conditions.isChecked -> {
                showErrorSnackBar(
                    resources.getString(R.string.error_missing_terms_and_conditions_field),
                    true
                )
                false
            }
            else -> {
                //showErrorSnackBar("Your details are valid", false)
                true
            }
        }
    }

    private fun registerUser() {
        if (validateRegisterDetails()) {

            showProgressDialog(resources.getString(R.string.please_wait))
            val email: String = til_email.text.toString().trim() { it <= ' ' }
            val password: String = et_passwordRegister.text.toString().trim() { it <= ' ' }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(OnCompleteListener<AuthResult> { task ->
                    //if registration is successful
                    if (task.isSuccessful) {
                        //Firebase registered user
                        val firebaseUser: FirebaseUser = task.result!!.user!!

                        val user = User(
                            firebaseUser.uid,
                            til_first_name.text.toString().trim() { it <= ' ' },
                            til_last_name.text.toString().trim() { it <= ' ' },
                            til_email.text.toString().trim() { it <= ' ' })

                        FirestoreClass().registerUser(this@RegisterActivity, user)

                     //   FirebaseAuth.getInstance().signOut()
                       // finish()

                    } else {
                        hideProgressDialog()
                        //if the registration is not succesful show the error message.
                        showErrorSnackBar(task.exception!!.message.toString(), true)
                    }
                })
        }
    }

    fun userRegistrationSuccess() {
        hideProgressDialog()

        Toast.makeText(
            this@RegisterActivity, resources.getString(R.string.register_success), Toast.LENGTH_LONG
        ).show()
    }
}