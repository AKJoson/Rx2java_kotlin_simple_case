package com.cherry.rxjavakotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cherry.rxjavakotlin.BR
import com.cherry.rxjavakotlin.R
import com.cherry.rxjavakotlin.adapter.BaseAdapter
import com.cherry.rxjavakotlin.databinding.ActivityMainBinding
import com.cherry.rxjavakotlin.databinding.ItemMainBinding
import com.cherry.rxjavakotlin.ui.operator.*
import com.cherry.rxjavakotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    var lists: List<String> =
        arrayOf(
            "just",
            "buffer",
            "debounce",
            "delay",
            "timer",
            "interval",
            "disposable",
            "distinct",
            "filter",
            "last",
            "map",
            "merge",
            "publishSubject",
            "reduce",
            "replay",
            "replaySubject",
            "scan",
            "doOnNext",
            "singleobservable",
            "skip",
            "take",
            "takeWhile",
            "throttleFirst",
            "throttleLast",
            "zip"
        ).toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val viewModel =
            ViewModelProvider(this, MainViewModel.Factory()).get(MainViewModel::class.java).apply {
                adapter = BaseAdapter<String>(R.layout.item_main, lists).apply {
                    listener = { holder, data, position ->
                        val itemBinding = holder.viewDataBinding as ItemMainBinding
                        itemBinding.setVariable(BR.textValue, data)
                        itemBinding.setClickListener {
                            navigateClick(data, position)
                        }
                        itemBinding.executePendingBindings()
                    }
                    layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                }
            }
        binding.viewModel = viewModel
    }

    private fun navigateClick(data: String, position: Int) {
        val intent: Intent = Intent()
        when (data) {
            "just" -> intent.setClass(this, JustActivity::class.java)
            "buffer" -> intent.setClass(this, BufferActivity::class.java)
            "debounce" -> intent.setClass(this, DebounceActivity::class.java)
            "delay" -> intent.setClass(this, DelayActivity::class.java)
            "timer" -> intent.setClass(this, TimerActivity::class.java)
            "interval" -> intent.setClass(this, IntervalActivity::class.java)
            "disposable" -> intent.setClass(this, DisposableActivity::class.java)
            "distinct" -> intent.setClass(this, DistinctActivity::class.java)
            "filter" -> intent.setClass(this, FilterActivity::class.java)
            "last" -> intent.setClass(this, LastActivity::class.java)
            "map" -> intent.setClass(this, MapActivity::class.java)
            "merge" -> intent.setClass(this, MergeActivity::class.java)
            "publishSubject" -> intent.setClass(this, PublishSubjectActivity::class.java)
            "reduce" -> intent.setClass(this, ReduceActivity::class.java)
            "replay" -> intent.setClass(this, ReplayActivity::class.java)
            "replaySubject" -> intent.setClass(this, ReplaySubjectActivity::class.java)
            "scan" -> intent.setClass(this, ScanActivity::class.java)
            "doOnNext" -> intent.setClass(this, DoOnNextActivity::class.java)
            "singleobservable" -> intent.setClass(this, SingleObservableActivity::class.java)
            "skip" -> intent.setClass(this, SkipActivity::class.java)
            "take" -> intent.setClass(this, TakeActivity::class.java)
            "takeWhile" -> intent.setClass(this, TakeWhileActivity::class.java)
            "throttleFirst" -> intent.setClass(this, ThrottleFirstActivity::class.java)
            "throttleLast" -> intent.setClass(this, ThrottleLastActivity::class.java)
            "zip" -> intent.setClass(this, ZipActivity::class.java)
        }
        startActivity(intent)
    }
}
