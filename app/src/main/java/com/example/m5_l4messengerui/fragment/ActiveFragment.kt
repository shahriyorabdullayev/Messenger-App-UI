package com.example.m5_l4messengerui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.adapter.ActiveAdapter
import com.example.m5_l4messengerui.model.Message


class ActiveFragment : Fragment() {
    private lateinit var rvActive:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_active, container, false)
        initViews(view)
        return view

    }

    private fun initViews(view: View) {
        rvActive = view.findViewById(R.id.rv_active)
        rvActive.layoutManager = GridLayoutManager(context, 1)


        refreshAdapter(getAllChats())

    }

    private fun getAllChats(): ArrayList<Message> {

        val list = ArrayList<Message>()

        for (i in 0..10){
            list.add(Message(R.drawable.img_add_story, "Abdullayev", true))
            list.add(Message(R.drawable.img_add_story, "Abdullayev", false))
            list.add(Message(R.drawable.img_add_story, "Abdullayev", true))
            list.add(Message(R.drawable.img_add_story, "Abdullayev", false))
            list.add(Message(R.drawable.img_add_story, "Abdullayev", true))
        }
            return list
    }

    private fun refreshAdapter(allChats: ArrayList<Message>) {
        val adapter = ActiveAdapter(context, allChats)
        rvActive.adapter = adapter

    }


}