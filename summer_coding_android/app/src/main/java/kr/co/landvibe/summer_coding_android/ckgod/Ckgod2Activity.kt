package kr.co.landvibe.summer_coding_android.ckgod

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.landvibe.summer_coding_android.ckgod.adapters.ItemListAdapter
import kr.co.landvibe.summer_coding_android.ckgod.adapters.ItemListAdapterListener
import kr.co.landvibe.summer_coding_android.ckgod.api.RetrofitHelper
import kr.co.landvibe.summer_coding_android.ckgod.api.data.User
import kr.co.landvibe.summer_coding_android.databinding.ActivityCkgod2Binding
import kr.co.landvibe.summer_coding_android.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Ckgod2Activity : AppCompatActivity() {
    companion object{
        const val TAG = "Ckgod2Activity"
    }
    private lateinit var binding: ActivityCkgod2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCkgod2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = RetrofitHelper.ckgodService.getUsers(1, 30)

        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.d(TAG, "response is ${response.body().toString()}")
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d(TAG, "error : ${t.localizedMessage}")
            }
        })

        RetrofitHelper.ckgodService.getUsers(1, 30).apply {
            enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    Log.d(TAG, "response is ${response.body().toString()}")
                    if(response.isSuccessful) {
                        response.body()?.let {
                            binding.rvList.adapter = ItemListAdapter(it, object : ItemListAdapterListener{
                                override fun onItemClick() {
                                    startActivity<Ckgod3Activity>()
                                }
                            })
                        }
                    }
                }
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.d(TAG, "error : ${t.localizedMessage}")
                }
            })
        }

        binding.btnTmp.setOnClickListener {
            val intent = Intent(this@Ckgod2Activity, CkgodActivity::class.java)
            intent.putExtra("result", "10,000")

            setResult(1500, intent)
            finish()
        }
    }
}