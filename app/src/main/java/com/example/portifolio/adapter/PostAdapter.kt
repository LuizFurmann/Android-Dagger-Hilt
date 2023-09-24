package com.example.portifolio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidflow.Models.MovieResponse
import com.example.portifolio.R


class PostAdapter(private val context: Context, private var postList: ArrayList<MovieResponse>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.body.load(""+post.resolutions.original.url)

    }

    override fun getItemCount(): Int = postList.size
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val body: ImageView = itemView.findViewById(R.id.body)
    }

    fun setData(postList: ArrayList<MovieResponse>) {
        this.postList = postList
        notifyDataSetChanged()
    }
}