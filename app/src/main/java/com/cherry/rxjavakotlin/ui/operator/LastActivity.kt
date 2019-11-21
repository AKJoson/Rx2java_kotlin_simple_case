package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.common_layout.*

/**
 *
 * Last
 *
 */
class LastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "last"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        Observable.just("123", "456", "789")
            .last("10JQ")
            .subscribe(object : SingleObserver<String> {
                override fun onSuccess(t: String) {
                    text_content.append("$t \n")
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