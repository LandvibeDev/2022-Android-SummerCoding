package kr.co.landvibe.summer_coding_android.d11210920

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.d11210920.friendsFragment
import kr.co.landvibe.summer_coding_android.databinding.ActivityD11210920Binding

class D11210920Activity : AppCompatActivity() {

    private val binding by lazy{ActivityD11210920Binding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bnvmain = binding.bottomNavigationView

        supportFragmentManager.beginTransaction().add(binding.linearLayout.id,friendsFragment()).commit()

        bnvmain.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.page_friendlist ->{
                    supportFragmentManager.beginTransaction().replace(R.id.linearLayout,friendsFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.page_chatlist ->{
                    supportFragmentManager.beginTransaction().replace(R.id.linearLayout,chatFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                else -> {return@setOnItemSelectedListener false}
            }
        }

    }



}