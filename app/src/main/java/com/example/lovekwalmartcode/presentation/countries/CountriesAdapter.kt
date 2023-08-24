package com.example.lovekwalmartcode.presentation.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lovekwalmartcode.R
import com.example.lovekwalmartcode.domain.model.CountryItem

class CountriesAdapter(var countries: List<CountryItem>) :
    RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]

        // Bind data to the views
        holder.nameAndRegionTextView.text = "${country.name}, ${country.region}"
        holder.codeTextView.text = country.code
        holder.capitalTextView.text = country.capital
    }

    override fun getItemCount() = countries.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameAndRegionTextView: TextView = view.findViewById(R.id.nameAndRegionTextView)
        val codeTextView: TextView = view.findViewById(R.id.codeTextView)
        val capitalTextView: TextView = view.findViewById(R.id.capitalTextView)
    }
}
