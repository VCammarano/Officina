package it.academy.android.italiancities.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.academy.android.italiancities.R
import it.academy.android.italiancities.entities.City

class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nameView: TextView
    private val acronymView: TextView

    init {
        nameView = view.findViewById(R.id.name)
        acronymView = view.findViewById(R.id.acronym)
    }

    fun showCity(city: City) {
        nameView.text = city.name
        acronymView.text = city.province.acronym
    }
}

class CityAdapter(private val model: List<City>) : RecyclerView.Adapter<CityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}