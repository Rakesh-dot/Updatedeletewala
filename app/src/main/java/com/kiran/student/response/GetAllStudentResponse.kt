package com.kiran.student.response

import com.kiran.student.entity.Student

class GetAllStudentResponse (
    val success:Boolean?=null,
    val count:Int?=null,
    val data:MutableList<Student>?=null,
)