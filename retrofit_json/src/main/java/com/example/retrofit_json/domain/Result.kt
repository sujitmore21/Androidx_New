package com.example.retrofit_json.domain

import com.google.gson.annotations.SerializedName

class Result {

    @field:SerializedName("new")
    val jsonMemberNew: Boolean? = null

    @field:SerializedName("countryDescription")
    val countryDescription: String? = null

    @field:SerializedName("activeStatus")
    val activeStatus: String? = null

    @field:SerializedName("countryCode")
    val countryCode: String? = null

    @field:SerializedName("id")
    val id: Int? = null

    @field:SerializedName("countryName")
    val countryName: String? = null
}