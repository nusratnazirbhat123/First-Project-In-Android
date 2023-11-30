// RegistrationActivity.kt
package com.example.mha
import RegistrationViewModel
import RegistrationViewModelFactory
import UserRepository
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mha.LoginActivity
import com.example.mha.R

class RegistrationActivity : AppCompatActivity() {

    private lateinit var registrationViewModel: RegistrationViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registrationViewModel = ViewModelProvider(
            this,
            RegistrationViewModelFactory(UserRepository(ApiService1.create()))
        ).get(RegistrationViewModel::class.java)

        val btnRegister = findViewById<Button>(R.id.RegisterButton)
        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etAddress = findViewById<EditText>(R.id.etAddress)


        btnRegister.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val address = etAddress.text.toString()

            registrationViewModel.registerUser(firstName, lastName, address)

            // Assuming you want to navigate to another activity after registration
//            val intent =
//                Intent(this, LoginActivity::class.java).also {
//                    startActivity(it)
//                }
        }
    }
}
