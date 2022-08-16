package kr.co.landvibe.summer_coding_android.gok5959.itemTouch

interface ItemTouchHelperListener {
    fun onItemMove(from_position : Int, to_position: Int): Boolean
    fun onItemSwipe(position: Int)
}