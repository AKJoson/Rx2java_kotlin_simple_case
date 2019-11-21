package com.cherry.rxjavakotlin.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter(value = ["app:adapter", "app:layoutManager", "itemDecoration"], requireAll = false)
fun recyclerView(
    view: View,
    adapter: RecyclerView.Adapter<BaseViewHolder>,
    layoutManager: RecyclerView.LayoutManager?,
    itemDecoration: RecyclerView.ItemDecoration?
) {
    val recyclerView = view as RecyclerView
    recyclerView.apply {
        this.adapter = adapter
        this.layoutManager = layoutManager

    }
}