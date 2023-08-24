package com.example.lovekwalmartcode.domain.repository

import android.util.Log
import com.example.lovekwalmartcode.data.remote.CountriesApi
import com.example.lovekwalmartcode.data.remote.dto.CountryItemDto
import com.example.lovekwalmartcode.data.repository.Repository

class RepositoryImpl(private val countriesApi: CountriesApi) : Repository {
    override suspend fun getCountries(): List<CountryItemDto> {
        try {
            return countriesApi.getCountries()
        } catch (exception: Exception) {
            Log.e("RepositoryImpl",exception.toString())
            throw exception
        }
    }



    }



