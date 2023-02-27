package com.example.officina.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carrepairshop.R

class AutoAdapter(private val auto: List<String>) :
    RecyclerView.Adapter<AutoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNumeroTelaio: TextView = itemView.findViewById(R.id.txtNumeroTelaio)
        val txtMarca: TextView = itemView.findViewById(R.id.txtMarca)
        val txtModello: TextView = itemView.findViewById(R.id.txtModello)
        val txtTarga: TextView = itemView.findViewById(R.id.txtTarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recicle_view_auto,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val auto = auto[position].split(" ")
        holder.txtNumeroTelaio.text = auto[0]
        holder.txtMarca.text = auto[1]
        holder.txtModello.text = auto[2]
        holder.txtTarga.text = auto[3]
    }

    override fun getItemCount(): Int {
        return auto.size
    }
}