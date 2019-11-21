package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.common_layout.*

class SingleObservableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "append"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        Single.just("123")
            .subscribe(object : SingleObserver<String> {
                override fun onSuccess(t: String) {
                    text_content.append("$t \n")
                }

                override fun onSubscribe(d: Disposable) {
                    text_content.append("onSubscribe")
                }

                override fun onError(e: Throwable) {
                    text_content.append(e.toString())
                }

            })
    }
}