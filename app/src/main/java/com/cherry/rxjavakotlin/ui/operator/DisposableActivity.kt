package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.common_layout.*

class DisposableActivity : AppCompatActivity() {
    val disposable: CompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "CompositeDisposable"
        button.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        disposable.add(Observable.just("123", "456", "789")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<String>() {
                override fun onComplete() {
                    text_content.append("onComplete")
                }

                override fun onNext(t: String) {
                    text_content.append("$t \n")
                }

                override fun onError(e: Throwable) {
                    text_content.append(e.toString())
                }

            })
        )
    }

    override fun finish() {
        super.finish()
        disposable.clear()
    }
}