package com.example.testproject.adapters.singleviewtype

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testproject.adapters.Data
import com.example.testproject.adapters.DataViewHolder

class SingleDataAdapter(
    private val onDataClickListener: ((data: Data) -> Unit)? = null
) : ListAdapter<Data, DataViewHolder>(DIFF_CALLBACK) {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = getItem(position).id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewHolder = DataViewHolder.createFrom(parent)
        if (onDataClickListener != null) {
            viewHolder.bnd.root.setOnClickListener {
                val data = getItem(viewHolder.adapterPosition)
                onDataClickListener.invoke(data)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    companion object {
        private const val TAG: String = "SingleDataAdapter"

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean = oldItem == newItem
        }
    }
}