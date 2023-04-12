package id.ac.ubaya.informatika.adv160420078week4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.ac.ubaya.informatika.adv160420078week4.R
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observable = Observable.just("a stream of data","hellow","world")

        val observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
                Log.d("Messages", "begin subscribe")
            }

            override fun onNext(t: String?) {
                Log.d("Messages", "data: $t")
            }

            override fun onError(e: Throwable?) {
                Log.e("Messages", "error: ${e!!.message.toString()}")
            }

            override fun onComplete() {
                Log.d("Messages", "complete")
            }
        }

    }
}