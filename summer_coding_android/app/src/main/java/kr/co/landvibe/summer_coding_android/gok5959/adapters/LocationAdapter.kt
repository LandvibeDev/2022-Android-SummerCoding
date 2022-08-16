package kr.co.landvibe.summer_coding_android.gok5959.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.landvibe.summer_coding_android.databinding.FooterGok5959Binding
import kr.co.landvibe.summer_coding_android.databinding.ItemViewGok5959Binding
import kr.co.landvibe.summer_coding_android.gok5959.Gok5959LocationinformationActivity
import kr.co.landvibe.summer_coding_android.gok5959.data.Location
import kr.co.landvibe.summer_coding_android.gok5959.data.locationItem
import kr.co.landvibe.summer_coding_android.gok5959.itemTouch.ItemTouchHelperListener
import kr.co.landvibe.summer_coding_android.gok5959.util.DiffUtilCallback

class LocationAdapter(private val locationList: MutableList<Location>) :
    ListAdapter<locationItem, RecyclerView.ViewHolder>(DiffUtilCallback()),
    ItemTouchHelperListener {
    lateinit var LocationAdded: String
    val HEADER = 0
    val ITEM = 1
    val FOOTER = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            ITEM -> LocationViewHolder(ItemViewGok5959Binding.inflate(LayoutInflater.from(
                parent.context),
                parent,
                false))
            FOOTER -> FooterViewHolder(FooterGok5959Binding.inflate(LayoutInflater.from(
                parent.context),
                parent,
                false))
            else -> {
                throw ClassCastException("error")
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FooterViewHolder -> {
                holder.binding.addBTN.setOnClickListener {
                    LocationAdded = holder.binding.addET.text.toString()
                    if (LocationAdded.equals("")) {
                        Toast.makeText(it.context, "입력하세요", Toast.LENGTH_SHORT).show()
                    } else {
                        addLocation()
                    }
                }
            }
            is LocationViewHolder -> {
                val item = getItem(position) as locationItem.Item
                holder.bind(item)
                holder.binding.locationCTRL.setOnClickListener {
                    val tmp : String = holder.binding.locationTV.text.toString()
                    val intent = Intent(holder.binding.locationCTRL?.context,
                        Gok5959LocationinformationActivity::class.java)
                    intent.putExtra("locationName", tmp)
                    ContextCompat.startActivity(holder.binding.locationCTRL.context, intent, null)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is locationItem.Footer -> FOOTER
            is locationItem.Item -> ITEM
            else -> 0
        }
    }


    class FooterViewHolder(val binding: FooterGok5959Binding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    class LocationViewHolder(val binding: ItemViewGok5959Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: locationItem.Item) { //
            binding.locationTV.text = item.name
        }
    }

    fun addLocation() {
        val newLocation = Location(LocationAdded, locationList.size + 1.toLong())
        locationList.add(newLocation)
        addFooterAndSubmitList(locationList)
    }

    override fun onItemMove(from_position: Int, to_position: Int): Boolean {
        val item = locationList[from_position]

        locationList.removeAt(from_position)
        locationList.add(to_position, item)
        addFooterAndSubmitList(locationList)
        return true;
    }

    override fun onItemSwipe(position: Int) {
        TODO("Not yet implemented")
    }

    fun addFooterAndSubmitList(list: MutableList<Location>?) {
        val items = when (list.isNullOrEmpty()) {
            true -> listOf(locationItem.Footer)
            false -> list.map { locationItem.Item(it) } + listOf(locationItem.Footer)
        }
        submitList(items)
    }
}

