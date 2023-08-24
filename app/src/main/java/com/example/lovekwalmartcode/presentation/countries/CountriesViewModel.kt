package com.example.lovekwalmartcode.presentation.countries

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lovekwalmartcode.domain.model.CountryItem
import com.example.lovekwalmartcode.domain.use_case.get_all_countries.GetAllCountriesUseCase
import com.example.lovekwalmartcode.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class CountriesViewModel(private val getAllCountriesUseCase: GetAllCountriesUseCase) : ViewModel() {

    private val _countries = MutableLiveData<Resource<List<CountryItem>>>()
    val countries: MutableLiveData<Resource<List<CountryItem>>> get() = _countries


    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        _countries.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val countriesList = getAllCountriesUseCase()
                _countries.postValue(Resource.Success(countriesList))
            } catch (exception: IOException) {
                _countries.postValue(Resource.Error("Network error. Please check your connection."))
            } catch (exception: Exception) {
                // For other unknown errors
                _countries.postValue(Resource.Error("Failed to fetch countries due to an unexpected error."))
                Log.e("CountriesViewModel", exception.toString())
            }
        }
    }


}
