package com.newgram.s2oul_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.Show
import kotlinx.android.synthetic.main.item_placedetail_shows.view.*

class PlaceDetailAdapater(val context: Context): RecyclerView.Adapter<PlaceDetailAdapater.PlaceDetailViewHolder>() {
    interface ItemClick {
        fun onClick(v: View, position: Int)
    }

    private var items = arrayListOf<Show>()

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceDetailViewHolder {
        return PlaceDetailViewHolder(LayoutInflater.from(context).inflate(R.layout.item_placedetail_shows, parent, false))
    }

    override fun onBindViewHolder(holder: PlaceDetailViewHolder, position: Int) {
        holder.run {
            items[position].let {
                bind(it)
            }
        }
        if(itemClick != null) {
            holder?.itemView?.setOnClickListener { v ->
                itemClick?.onClick(v, position)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    inner class PlaceDetailViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val image = itemView.findViewById<ImageView>(R.id.item_placedetail_iv)
        fun bind(item: Show) {
            with(view) {
                Glide.with(image)
                    .load(item.showImage)
                    .into(image)

                item_placedetail_name_tv.text = item.showName
            }
        }
    }

    fun addItems(shows: ArrayList<Show>) {
        shows.forEach {
            items.add(it)
            notifyItemInserted(items.size)
        }
    }

}