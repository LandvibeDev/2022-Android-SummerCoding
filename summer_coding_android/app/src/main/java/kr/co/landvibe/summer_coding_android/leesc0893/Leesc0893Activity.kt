package kr.co.landvibe.summer_coding_android.leesc0893

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.ActivityLeesc0893Binding
import kr.co.landvibe.summer_coding_android.leesc0893.adapter.BookAdapter
import kr.co.landvibe.summer_coding_android.leesc0893.api.BookService
import kr.co.landvibe.summer_coding_android.leesc0893.model.BestSellerDto
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class Leesc0893Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLeesc0893Binding
    private lateinit var adapter: BookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeesc0893Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()



        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com") // http 는 x , https 는 허용
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val bookService = retrofit.create(BookService::class.java)

        bookService.getBestSellerBooks("2513DC43FA0D012F7E9EF24437004EC8AAFD621E944D018691E66C2874B46AF0")
            .enqueue(object : Callback<BestSellerDto> {
                override fun onResponse( // 성공
                    call: Call<BestSellerDto>,
                    response: Response<BestSellerDto>
                ) {
                    if (response.isSuccessful.not()) {
                        Log.d(TAG, "response.isSuccessful.not()")
                        return
                    }
                    response.body()?.let { BestSellerDto ->
                        Log.d(TAG, BestSellerDto.toString())
                        BestSellerDto.books.forEach { book ->
                            Log.d(TAG, book.toString())
                        }
                        adapter.submitList(BestSellerDto.books)
                    }
                }

                override fun onFailure(call: Call<BestSellerDto>, t: Throwable) { // 실패
                    Log.d(TAG, t.toString())
                }

            })
        /*  bookService.getBooksByName()*/
    }

    private fun initRecyclerView(){
        adapter = BookAdapter()
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.adapter = adapter
    }

    companion object {
        private const val TAG: String = "Leesc0893Activity"
    }
}