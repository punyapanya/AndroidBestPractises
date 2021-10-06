package com.example.testproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.databinding.ItemDataBinding

class DataViewHolder private constructor(
    val bnd: ItemDataBinding
) : RecyclerView.ViewHolder(bnd.root) {

    fun bind(data: Data) {
        bnd.apply {
        }
    }

    companion object {
        fun createFrom(parent: ViewGroup): DataViewHolder = DataViewHolder(
            ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}