package com.example.lovekwalmartcode.presentation.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lovekwalmartcode.R
import com.example.lovekwalmartcode.domain.model.CountryItem

class CountriesAdapter(var countries: List<CountryItem>) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val codeTextView: TextView = itemView.findViewById(R.id.codeTextView)
        private val regionTextView: TextView = itemView.findViewById(R.id.regionTextView)
        private val capitalTextView: TextView = itemView.findViewById(R.id.capitalTextView)

        fun bind(country: CountryItem) {
            nameTextView.text = itemView.context.getString(R.string.label_name, country.name)
            regionTextView.text = itemView.context.getString(R.string.label_region, country.region)
            codeTextView.text = itemView.context.getString(R.string.label_code, country.code)
            capitalTextView.text = itemView.context.getString(R.string.label_capital, country.capital)


        }
    }
}
