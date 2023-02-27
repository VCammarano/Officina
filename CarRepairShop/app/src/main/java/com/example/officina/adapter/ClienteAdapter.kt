package com.example.officina.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carrepairshop.R

class ClienteAdapter(private val clienti: List<String>) :
    RecyclerView.Adapter<ClienteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        val txtCognome: TextView = itemView.findViewById(R.id.txtCognome)
        val txtTelefono: TextView = itemView.findViewById(R.id.txtTelefono)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recicle_view_cliente,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cliente = clienti[position].split(" ")
        holder.txtNome.text = cliente[0]
        holder.txtCognome.text = cliente[1]
        holder.txtTelefono.text = cliente[2]
    }

    override fun getItemCount(): Int {
        return clienti.size
    }
}