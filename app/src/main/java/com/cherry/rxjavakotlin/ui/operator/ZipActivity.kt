package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.common_layout.*

class ZipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "zip"
        button.setOnClickListener {
            doSomeWork()
        }
    }


    private fun doSomeWork() {
        val observable1 = Observable.just("A1", "A2", "A3", "A4")
        val observable2 = Observable.just("B1", "B2", "B3", "B4")
        Observable.zip(observable1, observable2,
            BiFunction<String, String, String> { t1, t2 ->
                t1 + t2
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onComplete() {
                    text_content.append("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    text_content.append("onSubscribe \n")
                }

                override fun onNext(t: String) {
                    text_content.append("$t \n")
                }

                override fun onError(e: Throwable) {
                    text_content.append("onError")
                }

            })


    }
}