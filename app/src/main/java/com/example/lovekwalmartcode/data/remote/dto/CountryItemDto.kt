package com.example.lovekwalmartcode.data.remote.dto


import com.example.lovekwalmartcode.domain.model.CountryItem
import com.google.gson.annotations.SerializedName

data class CountryItemDto(
    @SerializedName("capital")
    val capital: String? = "",
    @SerializedName("code")
    val code: String? = "",
    @SerializedName("demonym")
    val demonym: String? = "",
    @SerializedName("flag")
    val flag: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("region")
    val region: String? = ""

)


fun CountryItemDto.toCountryItem(): CountryItem {
    return CountryItem(
        capital = capital.orEmpty(),
        code = code.orEmpty(),
        flag = flag.orEmpty(),
        demonym = demonym.orEmpty(),
        name = name.orEmpty(),
        region = region.orEmpty()
    )

}



