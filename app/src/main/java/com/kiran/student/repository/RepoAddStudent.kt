package com.kiran.student.repository

import com.kiran.student.api.MyApiRequest
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.api.StudentAPI
import com.kiran.student.api.UserAPI
import com.kiran.student.entity.Student
import com.kiran.student.response.AddStudentResponse
import com.kiran.student.response.DeleteStudentResponse
import com.kiran.student.response.GetAllStudentResponse
import com.kiran.student.response.ImageResponse
import okhttp3.MultipartBody

class RepoAddStudent: MyApiRequest() {

    private val studentAPI = ServiceBuilder.buildService(StudentAPI::class.java)

    //Add Student
    suspend fun addStudent(student: Student): AddStudentResponse{
        return apiRequest {
            studentAPI.addStudent(
                ServiceBuilder.token!!, student
            )
        }
    }
    //delete student
    suspend fun deleteStudents(id:String):DeleteStudentResponse{
        return apiRequest {
            studentAPI.deleteStudent(ServiceBuilder.token!!,id)
        }
    }
    //update student


    suspend fun getAllStudents(): GetAllStudentResponse {
        return apiRequest {
            studentAPI.getAllStudents(ServiceBuilder.token!!)
        }
    }

    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            studentAPI.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }

}