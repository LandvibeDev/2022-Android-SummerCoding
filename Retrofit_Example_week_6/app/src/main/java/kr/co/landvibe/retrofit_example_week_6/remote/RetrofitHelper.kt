package kr.co.landvibe.retrofit_example_week_6.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Created by JJJoonngg
*/

object RetrofitHelper {

    private const val BASE_URL = "http://hp-api.herokuapp.com"

    private val retorofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val hpService: HPAPI = retorofit.create(HPAPI::class.java)
}