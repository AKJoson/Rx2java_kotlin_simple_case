package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.common_layout.*


class MergeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "merge"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        val observableA = Observable.just("A1", "A2", "A3", "A4")
        val observableB = Observable.just("B1","B2","B3","B4","B5")
        Observable.merge(observableA,observableB)
            .subscribe(object : Observer<String>{
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
                    text_content.append(e.toString())
                }

            })
    }
}