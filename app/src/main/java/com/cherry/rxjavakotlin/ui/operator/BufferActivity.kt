package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.common_layout.*

/**
 * buffer :
 *  3  each time emit the max capacity can't beyond the value.
 *  1  each time skip number.
 */
class BufferActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button?.text = "buffer"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        Observable.just("123", "456", "789", "10JQ", "KA")
            .buffer(3, 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<String>> {

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: List<String>) {
                    t.forEach {
                        text_content.append("$it  ")
                    }
                    text_content.append("\n")
                }

                override fun onError(e: Throwable) {
                    text_content.text = e.toString()
                }

                override fun onComplete() {
                    text_content.append("onmComplete \n")
                }

            })
    }
}