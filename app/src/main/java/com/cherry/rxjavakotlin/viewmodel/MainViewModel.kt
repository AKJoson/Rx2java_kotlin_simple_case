package com.cherry.rxjavakotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.cherry.rxjavakotlin.adapter.BaseAdapter

class MainViewModel : ViewModel() {

    lateinit var adapter: BaseAdapter<String>

    lateinit var layoutManager:RecyclerView.LayoutManager

    class Factory : ViewModelProvider.Factory {
        // if this MainViewMdoel need args you can init it in Factory construct.
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.newInstance()
        }
    }
}