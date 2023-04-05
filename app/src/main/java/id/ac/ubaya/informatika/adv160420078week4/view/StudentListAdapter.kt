package id.ac.ubaya.informatika.adv160420078week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.adv160420078week4.R
import id.ac.ubaya.informatika.adv160420078week4.model.Student
import id.ac.ubaya.informatika.adv160420078week4.util.loadImage
import kotlinx.android.synthetic.main.fragment_student_detail.view.*
import kotlinx.android.synthetic.main.student_list_item.view.*

var studenList = null

class StudentListAdapter(val studenList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }


    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(studenList[position].photoUrl, progressBar)

        holder.view.txtId.text = studenList[position].id
        holder.view.txtName.text = studenList[position].name
        holder.view.btnDetail.setOnClickListener {
            val studentId = studenList[position].id.toString()
            val studentName = studenList[position].name.toString()
            val studentBod = studenList[position].bod.toString()
            val studentPhone = studenList[position].phone.toString()
            val studentUrl = studenList[position].photoUrl.toString()
            val action = StudentListFragmentDirections.actionStudentDetail(studentId, studentName, studentBod, studentPhone, studentUrl)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return studenList.size
    }
}

