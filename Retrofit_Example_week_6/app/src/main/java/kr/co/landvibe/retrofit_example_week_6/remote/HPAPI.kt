package kr.co.landvibe.retrofit_example_week_6.remote

import kr.co.landvibe.retrofit_example_week_6.dto.HPCharacter
import retrofit2.Response
import retrofit2.http.GET

/*
* Created by JJJoonngg
*/

interface HPAPI {

    @GET("/api/characters")
    suspend fun getHPCharacters(): Response<HPCharacter>
}