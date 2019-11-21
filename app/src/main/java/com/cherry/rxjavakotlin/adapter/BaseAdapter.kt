package com.cherry.rxjavakotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<T>(
    private val layoutId: Int,
    private val lists: List<T>
) :
    RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var listener: (BaseViewHolder, T, Int) -> Unit

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        listener(holder, lists[position], position)
    }

}