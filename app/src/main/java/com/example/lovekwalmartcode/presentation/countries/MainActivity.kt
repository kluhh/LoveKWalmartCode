package com.example.lovekwalmartcode.presentation.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lovekwalmartcode.R
import com.example.lovekwalmartcode.dependency_injection.AppModule
import com.example.lovekwalmartcode.domain.use_case.get_all_countries.GetAllCountriesUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CountriesViewModel
    private lateinit var countriesAdapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countriesRecyclerView: RecyclerView = findViewById(R.id.countriesRecyclerView)
        countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        countriesAdapter = CountriesAdapter(emptyList()) // Initialized with an empty list
        countriesRecyclerView.adapter = countriesAdapter

        // Initialize ViewModel with the use case
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val getAllCountriesUseCase = GetAllCountriesUseCase(AppModule.repository())
                return CountriesViewModel(getAllCountriesUseCase) as T
            }
        }).get(CountriesViewModel::class.java)

        // Observe data changes and update UI
        viewModel.countries.observe(this, Observer { countries ->
            countriesAdapter.countries = countries
            countriesAdapter.notifyDataSetChanged()
        })
    }
}
