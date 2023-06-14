package id.ac.ubaya.informatika.adv160420078week4.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class Student(
    val id:String?,
    @SerializedName("student_name")
    val name:String?,
    @SerializedName("birth_of_date")
    val bod:String?,
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String
)


