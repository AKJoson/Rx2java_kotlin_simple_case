package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.common_layout.*
import java.util.concurrent.TimeUnit

class ThrottleFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "throttleFirst"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        getObserverable().subscribeOn(Schedulers.io())
            .throttleFirst(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onComplete() {
                    text_content.append("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    text_content.append("onSubscribe\n")
                }

                override fun onNext(t: String) {
                    text_content.append("$t \n")
                }

                override fun onError(e: Throwable) {
                    text_content.append(e.toString())
                }

            })
    }

    private fun getObserverable(): Observable<String> =
        Observable.create { emitter: ObservableEmitter<String> ->
            emitter.onNext("1")
            emitter.onNext("1.1")
            Thread.sleep(400)
            emitter.onNext("2")
            emitter.onNext("2.1")
            Thread.sleep(300)
            emitter.onNext("3")
            emitter.onNext("4")
            emitter.onComplete()
        }
}