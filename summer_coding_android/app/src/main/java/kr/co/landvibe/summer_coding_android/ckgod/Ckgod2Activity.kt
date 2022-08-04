package kr.co.landvibe.summer_coding_android.ckgod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.ActivityCkgod2Binding

class Ckgod2Activity : AppCompatActivity() {

    val s: String? by lazy {
        "ddd"
    }

    private lateinit var binding: ActivityCkgod2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCkgod2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTmp.text = intent.getStringExtra("keyName")

        binding.btnTmp.setOnClickListener {
            val intent = Intent(this@Ckgod2Activity, CkgodActivity::class.java)
            intent.putExtra("result", "10,000")

            setResult(1500, intent)
            finish()
        }
    }
}