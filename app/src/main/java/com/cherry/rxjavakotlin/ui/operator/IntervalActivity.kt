package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.common_layout.*
import java.util.concurrent.TimeUnit

class IntervalActivity : AppCompatActivity() {
    val disable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "interval"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    override fun finish() {
        super.finish()
        disable.clear()
    }

    private fun doSomeWork() {

        disable.add(
            Observable.interval(0, 1_000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<Long>() {
                    override fun onComplete() {
                        text_content.append("onComplete")
                    }

                    override fun onNext(t: Long) {
                        text_content.append("$t \n")
                    }

                    override fun onError(e: Throwable) {
                    }

                })
        )
    }

}