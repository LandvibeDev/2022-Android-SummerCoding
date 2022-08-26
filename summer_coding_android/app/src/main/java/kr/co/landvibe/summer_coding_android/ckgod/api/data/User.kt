package kr.co.landvibe.summer_coding_android.ckgod.api.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    val userName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("avatar_url")
    val image: String?
)