package com.example.m5_l4messengerui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.adapter.StoryAdapter
import com.example.m5_l4messengerui.model.Story


class StroiesFragment : Fragment() {

    private lateinit var rvStories:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stroies, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        rvStories = view.findViewById(R.id.rv_stories)

        rvStories.layoutManager = GridLayoutManager(context, 2)
        refreshAdapter(getAllStory())

    }

    private fun getAllStory(): ArrayList<Story> {

        val stories = ArrayList<Story>()
        stories.add(Story(R.drawable.ic_videocam, "Salommmm", 3))
        stories.add(Story(R.drawable.ic_videocam, "Salommmm", 3))
        stories.add(Story(R.drawable.ic_videocam, "Salommmm", 3))
        stories.add(Story(R.drawable.ic_videocam, "Salommmm", 3))
        stories.add(Story(R.drawable.ic_videocam, "Salommmm", 3))
        stories.add(Story(R.drawable.ic_videocam, "Salommmm", 3))
        return stories

    }

    private fun refreshAdapter(allStory: ArrayList<Story>) {
        val adapter = StoryAdapter(context, allStory)
        rvStories.adapter = adapter

    }


}