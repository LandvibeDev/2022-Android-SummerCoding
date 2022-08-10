package kr.co.landvibe.summer_coding_android.d11210920

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.d11210920.DATA.Item
import kr.co.landvibe.summer_coding_android.d11210920.adapters.ItemListAdapter
import kr.co.landvibe.summer_coding_android.databinding.ActivityD11210920Binding

class D11210920Activity : AppCompatActivity() {
    private lateinit var binding : ActivityD11210920Binding

    val data: List<Item> = listOf(
        Item(R.drawable.dh_img1,"참교육"),
        Item(R.drawable.dh_img2,"퀘스트지상주의"),
        Item(R.drawable.dh_img3,"윈드브레이커"),
        Item(R.drawable.dh_img4,"신의탑"),
        Item(R.drawable.dh_img5,"신화급 귀속아이템을 손에 넣었다"),
        Item(R.drawable.dh_img6,"뷰티풀 군바리"),
        Item(R.drawable.dh_img7,"백수세끼"),
        Item(R.drawable.dh_img8,"장씨세가 호위무사")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityD11210920Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dhRv.adapter = ItemListAdapter(data)
        val gridLayoutManager = GridLayoutManager(applicationContext,2)
        binding.dhRv.layoutManager = gridLayoutManager
    }
}