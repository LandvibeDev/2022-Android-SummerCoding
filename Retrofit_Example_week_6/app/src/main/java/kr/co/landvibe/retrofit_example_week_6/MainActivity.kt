package kr.co.landvibe.retrofit_example_week_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.landvibe.retrofit_example_week_6.databinding.ActivityMainBinding
import kr.co.landvibe.retrofit_example_week_6.remote.HPRepository
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val hpRepository = HPRepository()
    private lateinit var imgList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainButton.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                try {
                    val result = hpRepository.getHPCharacters()
                    Log.d("TAG_A", "result.code : ${result.code()}")
                    if (result.isSuccessful) {
                        withContext(Dispatchers.Main) {
                            result.body()?.let { resultBody ->
                                Log.d("TAG_A", "result body size : ${resultBody.size}")
                                imgList = resultBody.map { it.image }
                                imgList = imgList.filter { it.isNotEmpty() }
                                binding.randomButton.visibility = View.VISIBLE
                                binding.imageView.visibility = View.VISIBLE
                            }
                        }
                    } else {
                        //TODO : Fail
                    }
                } catch (e: Exception) {
                    Log.d("TAG_A", "exception : $e")
                }
            }
        }

        binding.randomButton.setOnClickListener {
            if (!::imgList.isInitialized) {
                return@setOnClickListener
            }

            val imgLink = imgList[Random.nextInt(imgList.size)]
            Log.d("TAG_A", "img Link : $imgLink")
            Glide.with(this)
                .load(imgLink)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)

        }
    }
}