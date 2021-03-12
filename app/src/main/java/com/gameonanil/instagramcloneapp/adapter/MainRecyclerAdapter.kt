package com.gameonanil.instagramcloneapp.adapter

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gameonanil.imatagramcloneapp.databinding.MainRecyclerList2Binding

import com.gameonanil.instagramcloneapp.models.Posts


class MainRecyclerAdapter( val context: Context, private val postList: List<Posts>):
    RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
      val binding = MainRecyclerList2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
       holder.bindTo(postList[position])
    }



    override fun getItemCount() = postList.size


    inner class MainRecyclerViewHolder(private val binding: MainRecyclerList2Binding): RecyclerView.ViewHolder(binding.root){
        fun bindTo(posts: Posts) {
            binding.apply {
                description.text = posts.description

                Glide.with(context)
                    .load(posts.image_url)
                    .into(postImageHome)


            }
        }

    }
}