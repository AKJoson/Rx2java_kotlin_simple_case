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
 * Distinct  remove the repeat element.
 */
class DistinctActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "Distinct"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        Observable.just("123", "456", "789", "123", "456", "789")
            .distinct()
            .subscribeOn(Schedulers.io())
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
}