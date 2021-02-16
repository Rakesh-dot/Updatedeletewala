package com.kiran.student.response

import com.kiran.student.entity.Student

data class AddStudentResponse (
    val success: Boolean? = null,
    val token: String? = null,
    val data:Student?=null
)