package com.example.retrofit_json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofit_json.domain.Country
import com.example.retrofit_json.domain.CountryResponse
import kotlinx.android.synthetic.main.activity_retrofitdemo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofitdemo)
        btnAdd.setOnClickListener {

            callRetrofit()

        }
    }

    private fun callRetrofit() {
        val service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java)
        val call=service.addCountry("",getCountryData())
        call.enqueue(object : Callback<CountryResponse> {
            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                Toast.makeText(applicationContext,"fail to fetch data",Toast.LENGTH_LONG).show()
                Log.i("@codekul","error response========>${t.message}")

            }

            override fun onResponse(call: Call<CountryResponse>, response: Response<CountryResponse>) {
                if (response.code()==200){
                    Toast.makeText(applicationContext,response.message(),Toast.LENGTH_LONG).show()
                    Log.i("@codekul","success response========>${response.body()}")
                }
                else{
                    Toast.makeText(applicationContext,"Authentication fail",Toast.LENGTH_LONG).show()
                    Log.i("@codekul","error response========>${response.code()}")
                }
            }
        })
    }

    private fun getCountryData(): Country {
        val country=Country()
        country.countryCode="CODE12345"
        country.countryDescription="hehehehhe"
        country.countryName="kakakak"
        return country
    }
}
