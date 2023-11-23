package com.example.ligasatu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ligasatu.MainActivity.Companion.DATA_CLUB
import com.example.ligasatu.databinding.ItemClubBinding

class ListClubAdapter(private val listClub: ArrayList<Club>) : RecyclerView.Adapter<ListClubAdapter.ListViewHolder>() {
    private lateinit var onItemCallback: OnItemCallback

    fun setOnItemCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }

    class ListViewHolder(var binding: ItemClubBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemClubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listClub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,berdiri,manager, pelatih, stadion, lokasi,deskripsi, logo, photo) =listClub[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgClub)
        Glide.with(holder.itemView.context)
            .load(logo)
            .into(holder.binding.imageView)
        holder.binding.tvNama.text = name
        holder.binding.tvStadion.text = stadion

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailClub::class.java)
            intentDetail.putExtra("key_club", listClub[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
//        holder.itemView.setOnClickListener { onItemCallback.onItemClicked(listClub[holder.adapterPosition]) }

    }
    interface OnItemCallback {
        fun onItemClicked(data: Club)
    }
}