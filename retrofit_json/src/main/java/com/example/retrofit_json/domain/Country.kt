package com.example.retrofit_json.domain

import com.google.gson.annotations.SerializedName

class Country {


    @field:SerializedName("countryDescription")
    var countryDescription: String? = null

    @field:SerializedName("countryCode")
    var countryCode: String? = null

    @field:SerializedName("countryName")
    var countryName: String? = null

}