package kr.co.landvibe.summer_coding_android.gok5959

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.ActivityGok5959LocationinformationBinding

class Gok5959LocationinformationActivity : AppCompatActivity() {
    lateinit var binding:ActivityGok5959LocationinformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGok5959LocationinformationBinding.inflate(layoutInflater)
        init()
        setContentView(binding.root)
    }

    fun init(){
        binding.locationTV.text = intent.getStringExtra("locationName")
        binding.backBTN.setOnClickListener {
            finish()
        }
    }
}