package kr.co.landvibe.summer_coding_android.gok5959.util

import androidx.recyclerview.widget.DiffUtil
import kr.co.landvibe.summer_coding_android.gok5959.data.Location
import kr.co.landvibe.summer_coding_android.gok5959.data.locationItem

class DiffUtilCallback : DiffUtil.ItemCallback<locationItem>(){


    override fun areItemsTheSame(oldItem: locationItem, newItem: locationItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: locationItem, newItem: locationItem): Boolean {
        return oldItem == newItem
    }

}