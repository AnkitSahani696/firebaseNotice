package com.example.firebasenoticeapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasenoticeapp.R
import com.example.firebasenoticeapp.adapter.NoticeAdapter
import com.example.firebasenoticeapp.model.NoticeModel
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var noticeList: ArrayList<NoticeModel>
    lateinit var adapter: NoticeAdapter
    val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        noticeList = ArrayList()

        adapter = NoticeAdapter(noticeList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        loadNotices()
    }

    private fun loadNotices() {

        firestore.collection("notices")
            .get()
            .addOnSuccessListener {

                for (doc in it) {
                    val notice = doc.toObject(NoticeModel::class.java)
                    noticeList.add(notice)
                }

                adapter.notifyDataSetChanged()
            }
    }
}