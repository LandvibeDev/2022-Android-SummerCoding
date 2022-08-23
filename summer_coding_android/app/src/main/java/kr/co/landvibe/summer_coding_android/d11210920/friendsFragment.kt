package kr.co.landvibe.summer_coding_android.d11210920

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kr.co.landvibe.summer_coding_android.AutoClearedValue
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.ckgod.data.Item
import kr.co.landvibe.summer_coding_android.databinding.DhFriendslistItemBinding
import kr.co.landvibe.summer_coding_android.databinding.FragmentFriendsBinding

class friendsFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentFriendsBinding>(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFriendsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val data_ : Item = Item(R.drawable.profile,"김동하")

        var data : MutableList<Item> = mutableListOf()

        for(i in 0..100){
            data.add(data_)
        }


        var recyclerViewAdapter = CustomAdapter(data)

        binding.dhRv.adapter = recyclerViewAdapter

    }

    class CustomAdapter(private val item_List: List<Item>) : RecyclerView.Adapter<CustomAdapter.Holder>(){

        class Holder(val binding: DhFriendslistItemBinding) : RecyclerView.ViewHolder(binding.root){
            fun setData(item: Item){
                binding.dhName.text = item.name
                binding.dhProfile.setImageDrawable(itemView.context.getDrawable(item.image))
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val binding = DhFriendslistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return Holder(binding)
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.setData(item_List[position])
        }

        override fun getItemCount(): Int {
            return item_List.size
        }

    }
}