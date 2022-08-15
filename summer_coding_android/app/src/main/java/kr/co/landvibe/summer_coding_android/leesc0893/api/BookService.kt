package kr.co.landvibe.summer_coding_android.leesc0893.api

import kr.co.landvibe.summer_coding_android.leesc0893.model.BestSellerDto
import kr.co.landvibe.summer_coding_android.leesc0893.model.SearchBookDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("/api/search.api?output=json") // json 으로 받아오는 것 고정
    fun getBooksByName(
        @Query("key") apiKey: String,
        @Query("query") keyword: String,
    ):Call<SearchBookDto>

    @GET("/api/bestSeller.api?output=json&categoryId=100") // json 으로 받아오는 것 고정
    fun getBestSellerBooks(
        @Query("key") apiKey: String,
    ):Call<BestSellerDto>
}