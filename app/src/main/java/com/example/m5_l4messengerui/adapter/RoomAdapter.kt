package com.example.m5_l4messengerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.model.Room
import com.google.android.material.imageview.ShapeableImageView
import org.w3c.dom.Text

class RoomAdapter(val context: Context?, val items:ArrayList<Room>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_STORY = 0
    private val TYPE_ITEM_CREATE = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return TYPE_ITEM_CREATE
        return TYPE_ITEM_STORY

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent, false)
            return RoomViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_create_room, parent, false)
        return CreateViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val room = items[position]

        if (holder is RoomViewHolder) {
            holder.apply {
                ivProfile.setImageResource(room.profile)
                tvFullname.text = room.fullname
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RoomViewHolder(view:View): RecyclerView.ViewHolder(view){

        val ivProfile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val tvFullname = view.findViewById<TextView>(R.id.tv_fullname)
    }

    class CreateViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }
}