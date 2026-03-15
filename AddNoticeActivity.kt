package com.example.firebasenoticeapp.activities

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasenoticeapp.R
import com.google.firebase.firestore.FirebaseFirestore

class AddNoticeActivity : AppCompatActivity() {

    lateinit var title: EditText
    lateinit var description: EditText
    lateinit var addBtn: Button

    val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notice)

        title = findViewById(R.id.titleEdit)
        description = findViewById(R.id.descriptionEdit)
        addBtn = findViewById(R.id.addBtn)

        addBtn.setOnClickListener {

            val notice = hashMapOf(

                "title" to title.text.toString(),
                "description" to description.text.toString()

            )

            firestore.collection("notices")
                .add(notice)
                .addOnSuccessListener {

                    Toast.makeText(this, "Notice Added", Toast.LENGTH_SHORT).show()
                    finish()

                }
                .addOnFailureListener {

                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

                }
        }
    }
}