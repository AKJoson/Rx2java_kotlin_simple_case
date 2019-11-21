package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.common_layout.*

class PublishSubjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "publishSubject"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        val publishSubject: PublishSubject<String> = PublishSubject.create()
        publishSubject.subscribe(observer1())
        publishSubject.onNext("A")
        publishSubject.onNext("B")
        publishSubject.onNext("C")
        publishSubject.subscribe(observer2())
        publishSubject.onNext("D")
        publishSubject.onNext("E")
    }

    private fun observer2(): Observer<String> {
        return object : Observer<String> {
            override fun onComplete() {
                text_content.append("observer2 onComplete\n")
            }

            override fun onSubscribe(d: Disposable) {
                text_content.append("observer2 onSubscrible\n")
            }

            override fun onNext(t: String) {
                text_content.append("Observer2 $t \n")
            }

            override fun onError(e: Throwable) {
                text_content.append(e.toString())
            }

        }
    }

    private fun observer1(): Observer<String> {
        return object : Observer<String> {
            override fun onComplete() {
                text_content.append("observer1 onComplete\n")
            }

            override fun onSubscribe(d: Disposable) {
                text_content.append(" observer1 onSubscribe\n")
            }

            override fun onNext(t: String) {
                text_content.append("observer1 $t \n")
            }

            override fun onError(e: Throwable) {
                text_content.append(e.toString())
            }

        }
    }

}
