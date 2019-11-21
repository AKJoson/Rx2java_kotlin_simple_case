// Generated by data binding compiler. Do not edit!
package com.cherry.rxjavakotlin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.cherry.rxjavakotlin.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemMainBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatTextView itemMainText;

  @Bindable
  protected String mTextValue;

  @Bindable
  protected View.OnClickListener mClickListener;

  protected ItemMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatTextView itemMainText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemMainText = itemMainText;
  }

  public abstract void setTextValue(@Nullable String textValue);

  @Nullable
  public String getTextValue() {
    return mTextValue;
  }

  public abstract void setClickListener(@Nullable View.OnClickListener clickListener);

  @Nullable
  public View.OnClickListener getClickListener() {
    return mClickListener;
  }

  @NonNull
  public static ItemMainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemMainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemMainBinding>inflateInternal(inflater, R.layout.item_main, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemMainBinding>inflateInternal(inflater, R.layout.item_main, null, false, component);
  }

  public static ItemMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemMainBinding)bind(component, view, R.layout.item_main);
  }
}
