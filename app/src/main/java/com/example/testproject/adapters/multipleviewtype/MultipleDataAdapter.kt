package com.example.testproject.adapters.multipleviewtype

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.adapters.Data
import com.example.testproject.adapters.DataViewHolder

class MultipleDataAdapter(
    private val onDataClickListener: ((data: Data) -> Unit)? = null,
    private val onBigDataClickListener: ((bigData: BigData) -> Unit)? = null,
) : ListAdapter<MultipleDataAdapter.Item, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = getItem(position).id

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is Item.BigDataItem -> Item.Type.DATA.ordinal
        is Item.DataItem -> Item.Type.BIG_DATA.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (Item.Type.values()[viewType]) {
        Item.Type.DATA -> {
            val viewHolder = DataViewHolder.createFrom(parent)
            if (onDataClickListener != null) {
                viewHolder.bnd.root.setOnClickListener {
                    val data = (getItem(viewHolder.adapterPosition) as Item.DataItem).data
                    onDataClickListener.invoke(data)
                }
            }
            viewHolder
        }
        Item.Type.BIG_DATA -> {
            val viewHolder = BigDataViewHolder.createFrom(parent)
            if (onBigDataClickListener != null) {
                viewHolder.bnd.root.setOnClickListener {
                    val bigData = (getItem(viewHolder.adapterPosition) as Item.BigDataItem).bigData
                    onBigDataClickListener.invoke(bigData)
                }
            }
            viewHolder
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int): Unit = when (val item = getItem(position)) {
        is Item.DataItem -> (holder as DataViewHolder).bind(item.data)
        is Item.BigDataItem -> (holder as BigDataViewHolder).bind(item.bigData)
    }

    sealed class Item(val id: Long) {
        data class DataItem(val data: Data) : Item(data.id)
        data class BigDataItem(val bigData: BigData) : Item(bigData.id)

        enum class Type { DATA, BIG_DATA }
    }

    companion object {
        private const val TAG: String = "MultipleDataAdapter"

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = when (oldItem) {
                is Item.DataItem -> newItem is Item.DataItem && oldItem == newItem
                is Item.BigDataItem -> newItem is Item.BigDataItem && oldItem == newItem
            }
        }
    }
}