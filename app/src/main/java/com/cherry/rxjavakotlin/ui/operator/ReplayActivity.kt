package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.observables.ConnectableObservable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.common_layout.*

class ReplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "replay"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        val source: PublishSubject<Int> = PublishSubject.create()
        val connectableObservable: ConnectableObservable<Int> = source.replay(3)
        connectableObservable.connect()
        connectableObservable.subscribe(getFirstObserver())
        source.onNext(1)
        source.onNext(2)
        source.onNext(3)
        source.onNext(4)
        source.onComplete()
        connectableObservable.subscribe(getSecondObserver())
    }

    private fun getSecondObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onComplete() {
                text_content.append("onComplete\n")
            }

            override fun onSubscribe(d: Disposable) {
                text_content.append("onSubscribe\n")
            }

            override fun onNext(t: Int) {
                text_content.append("secondObserver $t \n")
            }

            override fun onError(e: Throwable) {
                text_content.append(e.toString())
            }

        }
    }

    private fun getFirstObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onComplete() {
                text_content.append("FirstObserver onComplete \n")
            }

            override fun onSubscribe(d: Disposable) {
                text_content.append("FirstObserver onSubscribe \n")

            }

            override fun onNext(t: Int) {
                text_content.append("FirstObserver $t \n")
            }

            override fun onError(e: Throwable) {
            }

        }
    }
}