package com.cherry.rxjavakotlin.ui.operator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cherry.rxjavakotlin.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.common_layout.*
import java.lang.StringBuilder

/**
 * just 创建类型操作符
 */
class JustActivity : AppCompatActivity() {
    private val stringBuilder = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_layout)
        button.text = "just"
        button.setOnClickListener {
            doSomeWork()
        }
    }


    @SuppressLint("CheckResult")
    fun doSomeWork() {
        Observable.just("123", "456", "789", "10JQ", "KA")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                text_content.append("$it \n")
            }, {

            }, {
                text_content.append("onComplete")
            })
    }

}


