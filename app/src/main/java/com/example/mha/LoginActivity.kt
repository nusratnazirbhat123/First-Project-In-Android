
package com.example.mha
import android.Manifest
import ApiService
import LoginRepository
import LoginViewModel
import LoginViewModelFactory
import RetrofitClient
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LoginActivity : AppCompatActivity() {
    private var username: String = ""
    private var password: String = ""

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnRegister = findViewById<Button>(R.id.RegisterButton)

        btnRegister.setOnClickListener {
            // Start the RegistrationActivity
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        val apiService = RetrofitClient.create(ApiService::class.java)
        val repository = LoginRepository(apiService)
        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(repository)
        ).get(LoginViewModel::class.java)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            makeLoginRequest()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            viewModel.login(username, password)
        }

        viewModel.loginResult.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
    private fun makeLoginRequest() {
        // Check for the INTERNET permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted, proceed with the login request
            viewModel.login(username, password)
        } else {
            // Request the INTERNET permission
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET), INTERNET_PERMISSION_REQUEST_CODE)
        }
    }

    // ... Other code

    companion object {
        private const val INTERNET_PERMISSION_REQUEST_CODE = 1001
    }
}

