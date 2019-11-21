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
import java.util.concurrent.TimeUnit

/**
 *  debounce  this is amazing operator
 */
class DebounceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "debounce"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        getObservable().debounce(1_000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onComplete() {
                    text_content.append("onComplete")
                }

                override fun onNext(t: String) {
                    text_content.append("$t  \n")
                }

                override fun onError(e: Throwable) {
                    text_content.append(e.toString())
                }
            })
    }

    private fun getObservable(): Observable<String> {
        return Observable.create {
            it.onNext("10")
            Thread.sleep(800)   // 20  30 40
            it.onNext("20")
            Thread.sleep(1100)
            it.onNext("30")
            Thread.sleep(1100)
            it.onNext("40")
            it.onComplete()
        }
    }
}