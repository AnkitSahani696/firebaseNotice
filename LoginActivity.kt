package com.example.firebasenoticeapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasenoticeapp.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var loginBtn: Button
    lateinit var registerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        email = findViewById(R.id.emailEdit)
        password = findViewById(R.id.passwordEdit)
        loginBtn = findViewById(R.id.loginBtn)
        registerText = findViewById(R.id.registerText)

        loginBtn.setOnClickListener {

            val userEmail = email.text.toString().trim()
            val userPass = password.text.toString().trim()

            if (userEmail.isEmpty() || userPass.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(userEmail, userPass)
                .addOnSuccessListener {

                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                    if (userEmail == "admin@gmail.com") {
                        startActivity(Intent(this, AdminActivity::class.java))
                    } else {
                        startActivity(Intent(this, MainActivity::class.java))
                    }

                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
        }

        registerText.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}