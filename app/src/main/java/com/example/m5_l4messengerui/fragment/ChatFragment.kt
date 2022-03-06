package com.example.m5_l4messengerui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.adapter.ChatAdapter
import com.example.m5_l4messengerui.model.Chat
import com.example.m5_l4messengerui.model.Message
import com.example.m5_l4messengerui.model.Room


class ChatFragment : Fragment() {


    private lateinit var rvChat: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        // Inflate the layout for this fragment
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        rvChat = view.findViewById(R.id.rv_chat)

        rvChat.layoutManager = GridLayoutManager(context, 1)

        refreshAdapter(getAllChats())



    }

    private fun getAllChats(): ArrayList<Chat> {
        val stories: ArrayList<Room> = ArrayList()
        stories.add(Room(R.drawable.img_my, "Shahriyor Abdullayev"))
        stories.add(Room(R.drawable.img_my, "Shahriyor Abdullayev"))
        stories.add(Room(R.drawable.img_my, "Shahriyor Abdullayev"))
        stories.add(Room(R.drawable.img_my, "Shahriyor Abdullayev"))
        stories.add(Room(R.drawable.img_my, "Shahriyor Abdullayev"))
        stories.add(Room(R.drawable.img_my, "Shahriyor Abdullayev"))
        stories.add(Room(R.drawable.img_my, "Shahriyor Abdullayev"))
        stories.add(Room(R.drawable.img_my, "Shahriyor Abdullayev"))

        val chats: ArrayList<Chat> = ArrayList()

        chats.add(Chat(stories))

        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", true)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", true)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", false)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", true)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", true)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", false)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", true)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", false)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", true)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", false)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", true)))
        chats.add(Chat(Message(R.drawable.img_my, "Shahriyor Abdullayev", true)))

        return chats
    }

    private fun refreshAdapter(allChats: ArrayList<Chat>) {
        val adapter = ChatAdapter(context, allChats)
        rvChat.adapter = adapter

    }

}