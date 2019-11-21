package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.MaybeObserver
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.common_layout.*

class ReduceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "reduce"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        Observable.just(10, 20, 30, 40, 50)
            .reduce { t1, t2 -> t1 + t2 }.subscribe(object : MaybeObserver<Int> {
                override fun onSuccess(t: Int) {
                    text_content.append("onSuccess $t \n")
                }

                override fun onComplete() {
                    text_content.append("onComplete\n")
                }

                override fun onSubscribe(d: Disposable) {
                    text_content.append("onSubscribe\n")
                }

                override fun onError(e: Throwable) {
                    text_content.append(e.toString())
                }

            })
    }
}