package com.example.anproject3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anproject3.R
import com.example.anproject3.model.ClassicMusic
import com.example.anproject3.model.Classic
import com.example.anproject3.rest.MusicAPI
import com.squareup.picasso.Picasso

class ClassicAdapter(
    private val onTrackClicked: (Classic) -> Unit,
    private val classicList: MutableList<Classic> = mutableListOf()
) : RecyclerView.Adapter<ClassicViewHolder>() {

    fun updateClassic(newClassic: List<Classic>) {
        classicList.clear()
        classicList.addAll(newClassic)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassicViewHolder {
        val classicView = LayoutInflater.from(parent.context).inflate(R.layout.music_layout, parent, false)
        return ClassicViewHolder(classicView, onTrackClicked)
    }

    override fun onBindViewHolder(holder: ClassicViewHolder, position: Int) {
        val classicItem = classicList[position]
        holder.bind(classicItem)
    }

    override fun getItemCount(): Int = classicList.size
}

class ClassicViewHolder(itemView: View, val onTrackClicked: (Classic) -> Unit) : RecyclerView.ViewHolder(itemView) {
    val artistName: TextView = itemView.findViewById(R.id.artistName)
    val collectionName: TextView = itemView.findViewById(R.id.collectionName)
    val trackPhoto: ImageView = itemView.findViewById(R.id.trackPhoto)
    val trackPrice: TextView = itemView.findViewById(R.id.trackPrice)

    fun bind(classic: Classic) {
        artistName.text = classic.artistName
        collectionName.text = classic.collectionName
        trackPrice.text = classic.trackPrice.toString()

        itemView.setOnClickListener {
            onTrackClicked.invoke(classic)
        }

        Picasso.get()
            .load(MusicAPI.BASE_URL + classic.artworkUrl60)
            .placeholder(R.drawable.ic_baseline_filter_tilt_shift_24)
            .error(R.drawable.ic_baseline_clear_24)
            .resize(200, 200)
            .into(trackPhoto)
    }
}