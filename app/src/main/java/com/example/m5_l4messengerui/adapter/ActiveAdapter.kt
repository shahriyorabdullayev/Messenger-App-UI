package com.example.m5_l4messengerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.model.Message
import kotlin.system.measureTimeMillis

class ActiveAdapter(val context: Context?, val messages:ArrayList<Message>): RecyclerView.Adapter<ActiveAdapter.ActiveViewHolder>(){

    class ActiveViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_active_message, parent, false)
        return ActiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActiveViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return messages.size
    }
}