package kr.co.landvibe.summer_coding_android.leesc0893.model

import com.google.gson.annotations.SerializedName

data class BestSellerDto( // 이게 데이터를 한번에 가져오고 "Book" data class 의 정보들을 mapping 된 상태로 저장
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book>

)
