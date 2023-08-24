package com.example.lovekwalmartcode.domain.model

import com.google.gson.annotations.SerializedName

data class CountryItem(
    val capital: String? = "",
    val code: String? = "",
    val demonym: String? = "",
    val flag: String? = "",
    val name: String? = "",
    val region: String? = ""
)