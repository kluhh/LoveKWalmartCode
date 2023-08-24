package com.example.lovekwalmartcode.data.remote

import android.util.Log
import com.example.lovekwalmartcode.data.remote.dto.CountryItemDto
import com.example.lovekwalmartcode.utils.Constants
import retrofit2.http.GET

interface CountriesApi {

    @GET(Constants.COUNTRIES_GET_ALL_END_POINT)
    suspend fun getCountries(): List<CountryItemDto>

}
