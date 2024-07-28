package com.example.lovecat4.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.example.lovecat4.databinding.ItemLayoutBinding

class CatItemAdapter : ListAdapter<catModelItem, CatItemAdapter.CatViewHolder>(object :
    DiffUtil.ItemCallback<catModelItem>() {
    override fun areItemsTheSame(oldItem: catModelItem, newItem: catModelItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: catModelItem, newItem: catModelItem) =
        oldItem == newItem
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CatViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.ivAlbum
        fun bind(item: catModelItem) {
            Glide.with(imageView).load(item.url).transition(withCrossFade()).into(imageView)
        }
    }
}