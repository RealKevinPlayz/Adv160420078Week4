package id.ac.ubaya.informatika.adv160420078week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.adv160420078week4.R
import id.ac.ubaya.informatika.adv160420078week4.model.Student
import id.ac.ubaya.informatika.adv160420078week4.view.StudentDetailFragmentArgs.Companion.fromBundle
import id.ac.ubaya.informatika.adv160420078week4.viewmodel.DetailViewModel
import id.ac.ubaya.informatika.adv160420078week4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.*


class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    var studId = ""
    var studName = ""
    var studBod = ""
    var studPhone = ""
    var studUrl = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            studId = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
//            studName = StudentDetailFragmentArgs.fromBundle(requireArguments()).name
//            studBod = StudentDetailFragmentArgs.fromBundle(requireArguments()).bod
//            studPhone = StudentDetailFragmentArgs.fromBundle(requireArguments()).phone
//            studUrl = StudentDetailFragmentArgs.fromBundle(requireArguments()).url
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(studId)
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            txtCardId.setText(it.id)
            txtCardName.setText(it.name)
            txtBod.setText(it.bod)
            txtPhone.setText(it.phone)
        })
    }
}