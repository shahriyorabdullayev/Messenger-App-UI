package com.example.m5_l4messengerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l4messengerui.R
import com.example.m5_l4messengerui.model.Story

class StoryAdapter(val context: Context?, val stories:ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_CREATE_STORY = 0
    private val TYPE_STORY = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_CREATE_STORY
        }
        return TYPE_STORY
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_CREATE_STORY){
            return CreateStoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_people_create_view, parent, false))
        }
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_people_story_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return stories.size
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    }

    class CreateStoryViewHolder(view: View) :RecyclerView.ViewHolder(view){

    }
}