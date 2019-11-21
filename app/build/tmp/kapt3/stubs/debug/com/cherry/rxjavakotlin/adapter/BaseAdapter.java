package com.cherry.rxjavakotlin.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/cherry/rxjavakotlin/adapter/BaseAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/cherry/rxjavakotlin/adapter/BaseViewHolder;", "layoutId", "", "lists", "", "(ILjava/util/List;)V", "listener", "Lkotlin/Function3;", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
public class BaseAdapter<T extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.cherry.rxjavakotlin.adapter.BaseViewHolder> {
    @org.jetbrains.annotations.NotNull()
    public kotlin.jvm.functions.Function3<? super com.cherry.rxjavakotlin.adapter.BaseViewHolder, ? super T, ? super java.lang.Integer, kotlin.Unit> listener;
    private final int layoutId = 0;
    private final java.util.List<T> lists = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<com.cherry.rxjavakotlin.adapter.BaseViewHolder, T, java.lang.Integer, kotlin.Unit> getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super com.cherry.rxjavakotlin.adapter.BaseViewHolder, ? super T, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.cherry.rxjavakotlin.adapter.BaseViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.cherry.rxjavakotlin.adapter.BaseViewHolder holder, int position) {
    }
    
    public BaseAdapter(int layoutId, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> lists) {
        super();
    }
}