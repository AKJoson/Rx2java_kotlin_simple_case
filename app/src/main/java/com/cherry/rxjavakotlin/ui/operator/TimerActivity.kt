package com.cherry.rxjavakotlin.ui.operator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.common_layout.*
import java.util.concurrent.TimeUnit

class TimerActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "timer"
        button.setOnClickListener{
            doSomeWork()
        }
    }

    private fun doSomeWork() {
       Observable.timer(1000,TimeUnit.MILLISECONDS)
           .subscribe(object : Observer<Any>{
               override fun onComplete() {
                   text_content.append("onComplete \n")
               }

               override fun onSubscribe(d: Disposable) {
               }

               override fun onNext(t: Any) {
                   text_content.append("onNext \n")
               }

               override fun onError(e: Throwable) {
               }

           })
    }
}