package kr.co.landvibe.summer_coding_android.ckgod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.ckgod.fragments.Tmp2Fragment
import kr.co.landvibe.summer_coding_android.ckgod.fragments.TmpFragment
import kr.co.landvibe.summer_coding_android.databinding.ActivityCkgod3Binding

class Ckgod3Activity : AppCompatActivity() {
    private var flag = 1
    private lateinit var binding: ActivityCkgod3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCkgod3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        initFragment()
    }

    private fun initFragment() {
        val tmpFragment = TmpFragment()
        val tmp2Fragment = Tmp2Fragment()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.containerView, tmpFragment)
            commit()
        }

        binding.ivImage.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                when(flag) {
                    1 -> {
                        replace(R.id.containerView, tmp2Fragment)
                        flag++
                    }
                    2 -> {
                        replace(R.id.containerView, tmpFragment)
                        flag--
                    }
                }
                commit()
            }
        }

    }
}