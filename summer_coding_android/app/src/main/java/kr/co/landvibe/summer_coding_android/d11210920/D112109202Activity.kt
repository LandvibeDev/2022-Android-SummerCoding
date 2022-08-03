package kr.co.landvibe.summer_coding_android.d11210920

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.co.landvibe.summer_coding_android.databinding.ActivityD112109202Binding
import kr.co.landvibe.summer_coding_android.databinding.ActivityD11210920Binding

class D112109202Activity : AppCompatActivity() {

    private lateinit var binding: ActivityD112109202Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityD112109202Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var nowMoney:Int = intent.getStringExtra("money").toString().toInt()
        binding.run{
            dhSendButton.setOnClickListener {
                if(dhSendmoneyText.length() == 0){
                    Toast.makeText(getApplicationContext(), "값을 입력 해 주세요!", Toast.LENGTH_SHORT).show()
                }
                else if( dhSendmoneyText.getText().toString().toInt() == 0){
                    Toast.makeText(getApplicationContext(), "0원은 송금할 수 없습니다!", Toast.LENGTH_SHORT).show()
                }
                else{
                    nowMoney -= dhSendmoneyText.getText().toString().toInt()
                    setResult(RESULT_OK,intent)
                    intent.putExtra("newMoney",nowMoney.toString())
                    if(!isFinishing)finish()
                }
            }
        }

    }
}