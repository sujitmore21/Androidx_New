package com.example.retrofit_json.domain

import com.google.gson.annotations.SerializedName

class CountryResponse {


    @field:SerializedName("result")
    val result: Result? = null

    @field:SerializedName("message")
    val message: String? = null

    @field:SerializedName("status")
    val status: String? = null

}