package id.ac.ubaya.informatika.adv160420078week4.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyLog.TAG
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.adv160420078week4.model.Student

class DetailViewModel: ViewModel() {
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    val studentLD = MutableLiveData<Student>()
    fun fetch(id:String) {
        //val student1 = Student(id,name,bod,phone,url)
        //studentLD.value = student1
        Log.e("check id", id.toString())
        val url = "http://adv.jitusolution.com/student.php?id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                //val sType = object : TypeToken<ArrayList<Student>>() { }.type
                val result = Gson().fromJson<Student>("",
                    Student::class.java)
                studentLD.value = result
                Log.e("showvoley", result.toString())
            }
            ,
            {
                Log.e("showvoley", it.toString())
            })
        stringRequest.tag = TAG
    }
}
