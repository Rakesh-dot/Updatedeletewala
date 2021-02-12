package com.kiran.student.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiran.student.R
import com.kiran.student.adapter.StudentAdapter
import com.kiran.student.entity.Student
import com.kiran.student.repository.RepoAddStudent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewStudentActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        recyclerView = findViewById(R.id.recyclerView)

        loadStudents()
    }

    private fun loadStudents() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val studentRepository = RepoAddStudent()
                val response = studentRepository.getAllStudents()
                if(response.success==true){
                    // Put all the student details in lstStudents
                    val lstStudents = response.data
                    withContext(Dispatchers.Main){
                        val adapter = StudentAdapter(lstStudents as ArrayList<Student>, this@ViewStudentActivity)
                        recyclerView.layoutManager = LinearLayoutManager(this@ViewStudentActivity)
                        recyclerView.adapter = adapter
                    }
                }
            }catch(ex : Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ViewStudentActivity,
                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}