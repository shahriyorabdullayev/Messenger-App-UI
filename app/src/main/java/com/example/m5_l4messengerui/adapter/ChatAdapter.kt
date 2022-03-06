package com.example.m5_l4messengerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.model.Chat
import com.example.m5_l4messengerui.model.Room
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(val context: Context?, val items: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1


    override fun getItemViewType(position: Int): Int {
        var feed = items[position]

        if (feed.rooms.size > 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewHolder(context, view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]

        if (holder is RoomViewHolder) {
            refreshAdapter(message.rooms, holder.recyclerView)
        }

        if (holder is MessageViewHolder) {
            holder.apply {
                ivProfile.setImageResource(message.message!!.profile)
                tvFullname.text = message.message!!.fullname

                if (message.message!!.isOnline) {
                    isOnline.visibility = View.GONE
                } else {
                    isOnline.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {

        val adapter = RoomAdapter(context, rooms)
        recyclerView.adapter = adapter

    }


    override fun getItemCount(): Int {
        return items.size
    }


    class RoomViewHolder(context: Context?, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.rv_item)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = manager
        }


    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var ivProfile: ShapeableImageView
        var tvFullname: TextView
        var isOnline: LinearLayout

        init {
            ivProfile = view.findViewById(R.id.iv_profile)
            tvFullname = view.findViewById(R.id.tv_fullname)
            isOnline = view.findViewById(R.id.is_online)
        }


    }
}