package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.ReplaySubject
import kotlinx.android.synthetic.main.common_layout.*

class ReplaySubjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "replaySubject"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        val replaySubject: ReplaySubject<Int> = ReplaySubject.create()
        replaySubject.subscribe(getFirstObserver())
        replaySubject.onNext(1)
        replaySubject.onNext(2)
        replaySubject.onNext(3)
        replaySubject.onNext(4)
        replaySubject.onNext(5)
        replaySubject.onComplete()

        replaySubject.subscribe(getSecondObserver())
    }

    private fun getSecondObserver(): Observer<Int> = object : Observer<Int>{
        override fun onComplete() {
          text_content.append("Second onComplete \n")
        }

        override fun onSubscribe(d: Disposable) {
           text_content.append("Second onSubscribe\n")
        }

        override fun onNext(t: Int) {
          text_content.append("Second $t \n")
        }

        override fun onError(e: Throwable) {

        }

    }

    private fun getFirstObserver(): Observer<Int> = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            text_content.append("First onSubscribe \n")
        }

        override fun onNext(t: Int) {
            text_content.append("First $t \n")
        }

        override fun onError(e: Throwable) {
        }

        override fun onComplete() {
            text_content.append("onComplete\n")
        }

    }
}