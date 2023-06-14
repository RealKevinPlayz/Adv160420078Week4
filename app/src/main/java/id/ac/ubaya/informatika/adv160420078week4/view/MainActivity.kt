package id.ac.ubaya.informatika.adv160420078week4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import id.ac.ubaya.informatika.adv160420078week4.R
import id.ac.ubaya.informatika.adv160420078week4.util.createNotificationChannel
import id.ac.ubaya.informatika.adv160420078week4.util.showNotification
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    init {
        instance = this
    }
    companion object {

        var instance:MainActivity ?= null


        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel(
            this,
            NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel."
        )

        val fab = findViewById<FloatingActionButton>(R.id.fabNotif)
        fab.setOnClickListener() {
            val observableNotification = Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("Messages", "five seconds")
                    showNotification(
                        "Dummy",
                        "A new notification created",
                        R.drawable.ic_baseline_error_24
                    )

                }

            val observable = Observable.just("a stream of data", "hellow", "world")

            val observer = object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    Log.wtf("Messages", "begin subscribe")
                }

                override fun onNext(t: String?) {
                    Log.wtf("Messages", "data: $t")
                }

                override fun onError(e: Throwable?) {
                    Log.wtf("Messages", "error: ${e!!.message.toString()}")
                }

                override fun onComplete() {
                    Log.wtf("Messages", "complete")
                }
            }

            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
        }
    }
}