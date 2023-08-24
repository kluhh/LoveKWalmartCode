package com.example.lovekwalmartcode.presentation.countries

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lovekwalmartcode.domain.model.CountryItem
import com.example.lovekwalmartcode.domain.use_case.get_all_countries.GetAllCountriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class CountriesViewModel(private val getAllCountriesUseCase: GetAllCountriesUseCase) : ViewModel() {

    private val _countries = MutableLiveData<List<CountryItem>>()
    val countries: MutableLiveData<List<CountryItem>> get() = _countries

    private val _error = MutableLiveData<String>()
    val error: MutableLiveData<String> get() = _error


    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val countriesList = getAllCountriesUseCase()
                _countries.postValue(countriesList)
            } catch (exception: IOException) {
                _error.postValue("Network error. Please check your connection.")
            } catch (exception: Exception) {
                _error.postValue("An unexpected error occurred.")
                // Log for debugging
                Log.e("CountriesViewModel", exception.toString())
            }
        }
    }
}
