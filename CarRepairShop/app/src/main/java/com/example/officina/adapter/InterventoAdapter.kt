package com.example.officina.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carrepairshop.R
import com.example.officina.entities.Intervento

class InterventiAdapter(private val interventi: List<Intervento>) :
    RecyclerView.Adapter<InterventiAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtAuto: TextView = itemView.findViewById(R.id.txtAuto)
        val txtCliente: TextView = itemView.findViewById(R.id.txtCliente)
        val txtData: TextView = itemView.findViewById(R.id.txtData)
        val txtDescrizione: TextView = itemView.findViewById(R.id.txtDescrizione)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recicle_view_intervento,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val intervento = interventi[position].split()
        holder.txtAuto.text = intervento [0]
        holder.txtCliente.text = intervento [1]
        holder.txtData.text = intervento [2]
        holder.txtDescrizione.text = intervento [3]
    }

    override fun getItemCount(): Int {
        return interventi.size
    }
}