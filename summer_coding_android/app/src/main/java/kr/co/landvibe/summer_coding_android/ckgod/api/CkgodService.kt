package kr.co.landvibe.summer_coding_android.ckgod.api

import kr.co.landvibe.summer_coding_android.ckgod.api.data.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CkgodService {
    @GET("/users")
    fun getUsers(@Query("since") since: Int, @Query("per_page") per_page: Int): Call<List<User>>
}

