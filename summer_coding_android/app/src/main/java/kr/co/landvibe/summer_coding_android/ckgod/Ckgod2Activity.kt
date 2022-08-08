package kr.co.landvibe.summer_coding_android.ckgod

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.co.landvibe.summer_coding_android.ckgod.adapters.ItemListAdapter
import kr.co.landvibe.summer_coding_android.ckgod.data.Item
import kr.co.landvibe.summer_coding_android.databinding.ActivityCkgod2Binding

class Ckgod2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCkgod2Binding

    val data: List<Item> = listOf(
        Item("1", "고창국"),
        Item("1", "고창국"),
        Item("1", "고창국1"),
        Item("1", "고창국1"),
        Item("1", "고창2국"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCkgod2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTmp.setOnClickListener {
            val intent = Intent(this@Ckgod2Activity, CkgodActivity::class.java)
            intent.putExtra("result", "10,000")

            setResult(1500, intent)
            finish()
        }

        binding.rvList.adapter = ItemListAdapter(data)

    }
}