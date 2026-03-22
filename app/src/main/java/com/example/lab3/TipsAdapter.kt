package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipsAdapter(
    private val tips: List<Tip>,
    private val onItemClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.iv_image)
        val day: TextView = itemView.findViewById(R.id.tv_day)
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val shortDesc: TextView = itemView.findViewById(R.id.tv_short_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.image.setImageResource(tip.imageResId)
        holder.day.text = "День ${tip.day}"  // можно вынести в ресурсы для локализации
        holder.title.text = tip.title
        holder.shortDesc.text = tip.shortDescription
        holder.itemView.setOnClickListener { onItemClick(tip) }
    }

    override fun getItemCount() = tips.size
}