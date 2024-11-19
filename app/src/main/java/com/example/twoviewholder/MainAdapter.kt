package com.example.twoviewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val items: List<MainModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_VERTICAL = 1
        const val TYPE_HORIZONTAL = 2
    }

    inner class VerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.itemIcon)
        val title: TextView = itemView.findViewById(R.id.itemText)
    }

    inner class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.itemIcon)
        val title: TextView = itemView.findViewById(R.id.itemText)
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 5) {
            0, 1, 2 -> TYPE_VERTICAL
            3, 4 -> TYPE_HORIZONTAL
            else -> TYPE_VERTICAL
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HORIZONTAL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_horizontal, parent, false)
                HorizontalViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_vertical, parent, false)
                VerticalViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        when (holder) {
            is VerticalViewHolder -> {
                holder.image.setImageResource(R.drawable.ic_launcher_foreground)
                holder.title.text = item.title
            }
            is HorizontalViewHolder -> {
                holder.image.setImageResource(R.drawable.ic_launcher_foreground)
                holder.title.text = item.title
            }
        }
    }

    override fun getItemCount(): Int = items.size

}