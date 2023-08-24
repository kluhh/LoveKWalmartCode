package com.example.lovekwalmartcode.domain.use_case.get_all_countries

import com.example.lovekwalmartcode.data.remote.CountriesApi
import com.example.lovekwalmartcode.data.remote.dto.toCountryItem
import com.example.lovekwalmartcode.data.repository.Repository
import com.example.lovekwalmartcode.domain.model.CountryItem

class GetAllCountriesUseCase(private val repository: Repository) {
    suspend operator fun invoke(): List<CountryItem> {
        return repository.getCountries().map { it.toCountryItem() }
    }
}

