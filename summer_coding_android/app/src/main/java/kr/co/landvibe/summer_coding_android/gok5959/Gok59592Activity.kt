package kr.co.landvibe.summer_coding_android.gok5959

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.ActivityGok59592Binding
import kr.co.landvibe.summer_coding_android.gok5959.adapters.LocationAdapter
import kr.co.landvibe.summer_coding_android.gok5959.data.Location
import kr.co.landvibe.summer_coding_android.gok5959.data.locationItem
import kr.co.landvibe.summer_coding_android.gok5959.itemTouch.ItemTouchHelperCallback

class Gok59592Activity : AppCompatActivity() {

    private lateinit var text:String
    private lateinit var binding:ActivityGok59592Binding

    val location: MutableList<Location> = mutableListOf(
        Location("인하대학교 후문", 1),
        Location("캐리비안베이", 2),
        Location("파라다이스 시티", 3),
        Location("BBQ치킨 인하대후문점", 4),
        Location("인천국제공항 제1여객터미널", 5),
        Location("부평역", 6),
        Location("성원상떼빌아파트", 7),
        Location("광안대교", 8),
        Location("김해국제공항", 9),
        Location("CU 영주 적십자병원점", 10),
        Location("미진프라자", 11),
        Location("강남역 1번출구", 12)


    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGok59592Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = LocationAdapter(location)
        binding.locationRV.adapter = adapter

        val itemTouchHelperCallback = ItemTouchHelperCallback(adapter)

        val helper = ItemTouchHelper(itemTouchHelperCallback)
        helper.attachToRecyclerView(binding.locationRV)
        adapter.addFooterAndSubmitList(location)
    }



}