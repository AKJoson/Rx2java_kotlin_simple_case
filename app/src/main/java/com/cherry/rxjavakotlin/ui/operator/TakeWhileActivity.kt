package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.common_layout.*
import java.util.concurrent.TimeUnit

class TakeWhileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "takeWhile"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        Observable.just("123", "456", "789", "1314","123", "456", "789", "1314")
            .zipWith(Observable.interval(0, 1, TimeUnit.SECONDS),
                BiFunction<String, Long, String> { t1, t2 -> t1 })
            .takeWhile {
                !it.contains("852") // if return false ,current and next will not process.
            }
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

                }

            })
    }
}