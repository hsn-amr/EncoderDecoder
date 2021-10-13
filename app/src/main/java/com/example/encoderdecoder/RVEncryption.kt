package com.example.encoderdecoder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVEncryption(val encryptions: ArrayList<Encryption>): RecyclerView.Adapter<RVEncryption.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val encryption = encryptions[position]

        holder.itemView.apply {
            tvOriginalText.text = encryption.originalText
            tvCipherText.text = encryption.cipherText
        }
    }

    override fun getItemCount() = encryptions.size


}