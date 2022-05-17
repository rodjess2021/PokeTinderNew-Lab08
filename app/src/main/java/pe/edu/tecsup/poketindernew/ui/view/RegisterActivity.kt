package pe.edu.tecsup.poketindernew.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import pe.edu.tecsup.poketindernew.data.model.User
import pe.edu.tecsup.poketindernew.databinding.ActivityRegisterBinding
import pe.edu.tecsup.poketindernew.util.SharedPreferenceUtil

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }

    fun registerUser(view: View) {
        val user = User(
            id = "1",
            name = binding.edtUserName.text.toString(),
            email = binding.edtEmail.text.toString(),
            password = binding.edtPassword.text.toString())

        sharedPreferenceUtil.saveFacebookUser(user)
        val intent = Intent(applicationContext, LoginActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    fun loginUser(view: View) {
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }


}