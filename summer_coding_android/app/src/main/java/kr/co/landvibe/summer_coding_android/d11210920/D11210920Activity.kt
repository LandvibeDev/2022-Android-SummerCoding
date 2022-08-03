package kr.co.landvibe.summer_coding_android.d11210920

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.ActivityD11210920Binding

class D11210920Activity : AppCompatActivity() {

    private lateinit var binding : ActivityD11210920Binding
    private lateinit var activityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityD11210920Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        binding.run{
            dhSend.setOnClickListener {
                val intent = Intent(this@D11210920Activity,D112109202Activity::class.java).apply {  }
                intent.putExtra("money",dhHowmuch.text)
                activityResultLauncher.launch(intent)
            }

            activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
                if(result.resultCode == RESULT_OK){
                    val receive_money:String? = result.data!!.getStringExtra("newMoney")
                    dhHowmuch.setText(receive_money)
                }
            }

        }
    }

}