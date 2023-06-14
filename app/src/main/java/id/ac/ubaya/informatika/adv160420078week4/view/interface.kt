package id.ac.ubaya.informatika.adv160420078week4.view

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.adv160420078week4.R
import id.ac.ubaya.informatika.adv160420078week4.util.showNotification
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

interface ButtonDetailClickListener {
    fun onButtonDetailClick(v:View){
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
            Navigation.findNavController(v).navigate(action)
    }

    fun onButtonUpdateClick(v:View){

    }

    fun onButtonNotifClick(v:View){

    }
}