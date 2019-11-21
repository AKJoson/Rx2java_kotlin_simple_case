package com.cherry.rxjavakotlin.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


open class BaseViewHolder(val viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder(viewDataBinding.root)