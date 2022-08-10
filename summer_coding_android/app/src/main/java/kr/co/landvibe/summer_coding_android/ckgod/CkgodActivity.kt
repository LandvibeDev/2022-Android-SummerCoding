package kr.co.landvibe.summer_coding_android.ckgod

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kr.co.landvibe.summer_coding_android.databinding.ActivityCkgodBinding
import java.text.DecimalFormat


class CkgodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCkgodBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCkgodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.run {
            activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                when(result.resultCode) {
                    1500 -> {
                        tvMainMoneyCount.text = result.data?.getStringExtra("result")
                    }
                    2000 -> {

                    }
                }
            }

            tvTransfer.setOnClickListener {
                val intent = Intent(this@CkgodActivity, Ckgod2Activity::class.java)
                intent.putExtra("keyName", tvMainMoneyCount.text.toString())
                activityResultLauncher.launch(intent)
            }
        }
    }

}