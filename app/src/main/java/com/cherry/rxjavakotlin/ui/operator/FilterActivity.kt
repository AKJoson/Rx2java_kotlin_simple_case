package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.common_layout.*

class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "Filter"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        Observable.just(1, 5, 6, 10, 78, 212, 12)
            .filter {
                it > 20
            }.subscribe(object : Observer<Int> {
                override fun onComplete() {
                    text_content.append("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    text_content.append("onSubscribe")
                }

                override fun onNext(t: Int) {
                    text_content.append("$t \n")
                }

                override fun onError(e: Throwable) {
                    text_content.append(e.toString())
                }

            })
    }
}