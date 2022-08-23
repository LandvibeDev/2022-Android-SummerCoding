package kr.co.landvibe.summer_coding_android.d11210920

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kr.co.landvibe.summer_coding_android.AutoClearedValue
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.*

class chatFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentChatBinding>(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        var chatdata : MutableList<chatItem> = mutableListOf()

        for(i in 1..101){
            val chatdata_ : chatItem = chatItem(R.drawable.profile,"단체채팅방${i}","안녕하세요")
            chatdata.add(chatdata_)
        }


        var recyclerViewAdapter = CustomAdapter(chatdata)

        binding.dhChatRv.adapter = recyclerViewAdapter

    }

    class CustomAdapter(private val item_List: List<chatItem>) : RecyclerView.Adapter<CustomAdapter.Holder>(){

        class Holder(val binding: DhChatlistItemBinding) : RecyclerView.ViewHolder(binding.root){
            fun setData(item: chatItem){
                binding.dhChatName.text = item.name
                binding.dhChatprofile.setImageDrawable(itemView.context.getDrawable(item.image))
                binding.dhChatContent.text = item.content
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val binding = DhChatlistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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