package com.example.lovekwalmartcode.dependency_injection

import com.example.lovekwalmartcode.domain.repository.RepositoryImpl
import com.example.lovekwalmartcode.data.remote.CountriesApi
import com.example.lovekwalmartcode.data.repository.Repository
import com.example.lovekwalmartcode.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppModule private constructor() {

    companion object {
        private val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        private val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(Constants.COUNTRIES_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private fun countriesApi(): CountriesApi = retrofit.create(CountriesApi::class.java)

        fun repository(): Repository = RepositoryImpl(countriesApi())
    }
}






