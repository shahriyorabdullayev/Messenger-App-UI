package com.example.m5_l4messengerui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.adapter.StoryAdapter
import com.example.m5_l4messengerui.model.Story


class PeopleFragment : Fragment() {

    private lateinit var storiesFragment: StroiesFragment

    private lateinit var tvStories:TextView
    private lateinit var tvActive:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_people, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        tvStories = view.findViewById(R.id.tv_stories)
        tvActive = view.findViewById(R.id.tv_active)

        storiesFragment = StroiesFragment()

        loadFragment(storiesFragment)

        tvStories.setOnClickListener {
            tvActive.setBackgroundResource(0)
            tvStories.setBackgroundResource(R.drawable.shape_text_background)

            loadFragment(storiesFragment)
        }

        tvActive.setOnClickListener {
            tvStories.setBackgroundResource(0)
            tvActive.setBackgroundResource(R.drawable.shape_text_background)

            loadFragment(ActiveFragment())
        }

    }

    private fun loadFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.frame_people, fragment)
            .commit()
    }





}