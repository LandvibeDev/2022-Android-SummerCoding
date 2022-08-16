package kr.co.landvibe.summer_coding_android.gok5959

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.ActivityGok5959Binding

class Gok5959Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGok5959Binding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private val TAG:String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGok5959Binding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "init")
        initView()
        Log.d(TAG, "init2")
    }

    fun initView() {
        binding.run {
            activityResultLauncher =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    when (result.resultCode) {
                        1000 -> {
                            nameTV.text = result.data?.getStringExtra("inputText")
                        }
                    }
                }
        }

        binding.nameBTN.setOnClickListener {
            val intent = Intent(this@Gok5959Activity, Gok59592Activity::class.java)
            activityResultLauncher.launch(intent)
        }
    }
}