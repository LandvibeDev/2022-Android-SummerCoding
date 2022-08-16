package kr.co.landvibe.summer_coding_android.gok5959.data

sealed class locationItem{
    abstract var id: Long
    abstract var name: String
    data class Item(val location: Location) : locationItem() {
        override var id = location.id
        override var name = location.name

    }
    object Footer : locationItem(){
        override var id = Long.MAX_VALUE
        override var name = ""
    }
}

