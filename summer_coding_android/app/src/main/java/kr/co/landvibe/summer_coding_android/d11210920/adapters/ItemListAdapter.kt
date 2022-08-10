package kr.co.landvibe.summer_coding_android.d11210920.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.d11210920.DATA.Item
import kr.co.landvibe.summer_coding_android.databinding.ItemViewBinding

class ItemListAdapter (private val itemList: List<Item>) : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>(){



    class ItemViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            binding.dhToonTv.text = item.name
            binding.dhToonImage.setImageDrawable(itemView.context.getDrawable(item.image))
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}


