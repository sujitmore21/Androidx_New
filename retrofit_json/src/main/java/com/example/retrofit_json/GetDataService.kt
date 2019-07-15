package com.example.retrofit_json

import com.example.retrofit_json.domain.Country
import com.example.retrofit_json.domain.CountryResponse
import retrofit2.Call
import retrofit2.http.*

interface GetDataService {

    @POST("master/country/addCountry")
    fun addCountry(@Header("Authorization") token: String, @Body country: Country): Call<CountryResponse>


    @GET("master/country/getCountry")
    fun getCountry(@Header("Authorization") token: String, @Query("id")id:Long):Call<CountryResponse>
}