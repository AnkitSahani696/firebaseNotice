package com.example.firebasenoticeapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasenoticeapp.R

class AdminActivity : AppCompatActivity() {

    lateinit var addNoticeBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        addNoticeBtn = findViewById(R.id.addNoticeBtn)

        addNoticeBtn.setOnClickListener {

            startActivity(Intent(this, AddNoticeActivity::class.java))

        }
    }
}