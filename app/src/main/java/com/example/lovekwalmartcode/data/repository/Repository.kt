package com.example.lovekwalmartcode.data.repository

import com.example.lovekwalmartcode.data.remote.dto.CountryItemDto

interface Repository {
    suspend fun getCountries(): List<CountryItemDto>

}