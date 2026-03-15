package com.example.firebasenoticeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasenoticeapp.R
import com.example.firebasenoticeapp.model.NoticeModel

class NoticeAdapter(
    private val noticeList: ArrayList<NoticeModel>
) : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.noticeTitle)
        val description: TextView = itemView.findViewById(R.id.noticeDescription)
        val date: TextView = itemView.findViewById(R.id.noticeDate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notice, parent, false)

        return NoticeViewHolder(view)
    }

    override fun getItemCount(): Int {

        return noticeList.size

    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {

        val notice = noticeList[position]

        holder.title.text = notice.title
        holder.description.text = notice.description
        holder.date.text = notice.date

    }
}