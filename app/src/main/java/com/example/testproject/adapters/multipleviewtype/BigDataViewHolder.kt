package com.example.testproject.adapters.multipleviewtype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.databinding.ItemBigDataBinding

class BigDataViewHolder private constructor(
    val bnd: ItemBigDataBinding
) : RecyclerView.ViewHolder(bnd.root) {

    fun bind(bigData: BigData) {
        bnd.apply {
        }
    }

    companion object {
        fun createFrom(parent: ViewGroup): BigDataViewHolder = BigDataViewHolder(
            ItemBigDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}