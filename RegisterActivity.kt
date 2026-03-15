package com.example.firebasenoticeapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasenoticeapp.R
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var registerBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        email = findViewById(R.id.emailEdit)
        password = findViewById(R.id.passwordEdit)
        registerBtn = findViewById(R.id.registerBtn)

        registerBtn.setOnClickListener {

            val userEmail = email.text.toString().trim()
            val userPass = password.text.toString().trim()

            if (userEmail.isEmpty() || userPass.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userPass.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(userEmail, userPass)
                .addOnSuccessListener {

                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .addOnFailureListener {

                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
        }
    }
}