package pe.edu.tecsup.poketindernew.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import pe.edu.tecsup.poketindernew.data.model.User
import pe.edu.tecsup.poketindernew.databinding.ActivityLoginBinding
import pe.edu.tecsup.poketindernew.ui.viewmodel.LoginViewModel
import pe.edu.tecsup.poketindernew.util.SharedPreferenceUtil

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = LoginViewModel(this)

        loginViewModel.onCreate()

        loginViewModel.emptyFieldsError.observe(this) {
            Toast.makeText(this, "Ingrese los datos de  Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldsAuthenticateError.observe(this) {
            Toast.makeText(this, "Error Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSuccesActivity.observe(this) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun startLogin(view: View) {
        loginViewModel.validateInputs(binding.edtEmail.text.toString(), binding.edtPassword.text.toString())
    }
}