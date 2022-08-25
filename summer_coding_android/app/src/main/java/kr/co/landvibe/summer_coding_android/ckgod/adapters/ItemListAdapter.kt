package kr.co.landvibe.summer_coding_android.ckgod.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.ckgod.data.Item
import kr.co.landvibe.summer_coding_android.databinding.ItemViewBinding

interface ItemClickListener {
    fun onItemClick(itemName: String)
}

// Adapter는 RecyclerView.Adapter를 상속받는다.
class ItemListAdapter(private val itemList: List<Item>, private val listener: ItemClickListener) : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {
    // Adapter<.....> 데이터를 어떤 뷰로 바꿀지에 대한 뷰홀더를 넣어준다.
    // itemList : Adapter는 ViewHolder에 넣을 데이터를 가지고 있어야 한다.


    // 어댑터는 아이템마다 뷰홀더 만드는 방법을 정의한다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
        // LayoutInflater : xml layout을 자바에서 쓸 수 있도록 하는 과정이 inflate, 따라서 이러한 inflate 과정을 통해 뷰를 만들때 LayoutInflater가 사용된다.
        // .from(context) : 앱의 리소스에 접근하기 위해선 context가 필요하다. 사용할 뷰의 참조를 전달하기 위해서 context를 전달
        // return ItemViewHolder(binding) : 생성된 뷰 바인딩을 뷰홀더에 넣어주고 뷰홀더 리턴
    }

    // 뷰홀더로 데이터를 전달한다
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position]) // 뷰홀더에 데이터 전달 (현재 보여지는 position에 맞는)
    }

    // 어댑터는 전체 아이템 수를 알아야한다.
    override fun getItemCount(): Int = itemList.size

    inner class ItemViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) { // onBindViewHolder에서 데이터를 전달받기 위한 함수 생성

            // 받은 데이터를 뷰에 매칭
            binding.tvName.text = item.name
            binding.ivImage.setImageDrawable(itemView.context.getDrawable(item.image))


            itemView.setOnClickListener {
                listener.onItemClick(item.name)
            }
        }
    }
}