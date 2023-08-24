package com.example.lovekwalmartcode.presentation.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lovekwalmartcode.data.repository.Repository
import com.example.lovekwalmartcode.domain.model.CountryItem
import com.example.lovekwalmartcode.domain.use_case.get_all_countries.GetAllCountriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountriesViewModel(private val getAllCountriesUseCase: GetAllCountriesUseCase) : ViewModel() {

    private val _countries = MutableLiveData<List<CountryItem>>()
    val countries: MutableLiveData<List<CountryItem>> get() = _countries

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val countriesList = getAllCountriesUseCase()
                _countries.postValue(countriesList)
            } catch (exception: Exception) {
                // handle errors
            }
        }
    }
}
