package id.ac.ubaya.informatika.adv160420078week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.adv160420078week4.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()
    fun fetch(id:String, name:String, bod:String, phone:String, url:String) {
        val student1 = Student(id,name,bod,phone,url)
        studentLD.value = student1
    }
}
