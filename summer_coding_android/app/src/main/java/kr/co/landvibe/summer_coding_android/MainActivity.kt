package kr.co.landvibe.summer_coding_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import kr.co.landvibe.summer_coding_android.ckgod.CkgodActivity
import kr.co.landvibe.summer_coding_android.d11210920.D11210920Activity
import kr.co.landvibe.summer_coding_android.gok5959.Gok5959Activity
import kr.co.landvibe.summer_coding_android.leesc0893.Leesc0893Activity
import kr.co.landvibe.summer_coding_android.yesxon.YesxonActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        findViewById<AppCompatButton>(R.id.btnD11).setOnClickListener { startActivity<D11210920Activity>() }
        findViewById<AppCompatButton>(R.id.btnGok).setOnClickListener { startActivity<Gok5959Activity>() }
        findViewById<AppCompatButton>(R.id.btnLee).setOnClickListener { startActivity<Leesc0893Activity>() }
        findViewById<AppCompatButton>(R.id.btnYes).setOnClickListener { startActivity<YesxonActivity>() }
        findViewById<AppCompatButton>(R.id.btnCkg).setOnClickListener { startActivity<CkgodActivity>() }
    }
}