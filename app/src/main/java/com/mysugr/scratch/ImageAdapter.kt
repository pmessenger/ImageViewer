package com.mysugr.scratch

import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ImageAdapter(val showAction: (url: String, finishedAction: (Bitmap?) -> Unit) -> Unit) : RecyclerView.Adapter<CardViewHolder>() {

    var imageUrls: List<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardViewHolder? {
        val cardView = LayoutInflater.from(parent?.context).inflate(R.layout.list_entry, parent, false)
        return CardViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return imageUrls.count();
    }

    override fun onBindViewHolder(holder: CardViewHolder?, position: Int) {
        holder!!.reset()
        showAction(imageUrls[position], { bitmap -> setImage(holder, bitmap) });
    }

    private fun setImage(holder: CardViewHolder, image: Bitmap?) {
        if (image == null) return

        holder.setImage(image)
    }
}