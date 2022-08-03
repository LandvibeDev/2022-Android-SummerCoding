package kr.co.landvibe.summer_coding_android.gok5959

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.ActivityGok59592Binding

class Gok59592Activity : AppCompatActivity() {

    private lateinit var text:String
    private lateinit var binding:ActivityGok59592Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGok59592Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    fun initButton() {

        binding.finishBTN.setOnClickListener {
            text = binding.et1.text.toString()
            Log.d("main", text)
            val intent = Intent(this@Gok59592Activity, Gok5959Activity::class.java)
            intent.putExtra("inputText", text)

            setResult(1000, intent)
            finish()
        }

    }

}