package kr.co.landvibe.retrofit_example_week_6.dto


import com.google.gson.annotations.SerializedName

data class Wand(
    @SerializedName("core") val core: String,
    @SerializedName("length") val length: String,
    @SerializedName("wood") val wood: String
)