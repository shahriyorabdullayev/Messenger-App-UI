package com.example.m5_l4messengerui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.adapter.ChatAdapter
import com.example.m5_l4messengerui.fragment.ChatFragment
import com.example.m5_l4messengerui.fragment.PeopleFragment
import com.example.m5_l4messengerui.model.Chat
import com.example.m5_l4messengerui.model.Message
import com.example.m5_l4messengerui.model.Room
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var chatFragment: ChatFragment
    private lateinit var peopleFragment: PeopleFragment

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        chatFragment = ChatFragment()
        peopleFragment = PeopleFragment()

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.menu.getItem(0).isCheckable = true
        loadFragment(chatFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {menu ->

            when(menu.itemId){
                R.id.page_chat -> {
                    loadFragment(chatFragment)
                    true
                }
                R.id.page_people -> {
                    loadFragment(peopleFragment)
                    true
                }
                else -> false
            }
        }





    }


    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }




}