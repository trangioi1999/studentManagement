package com.example.studentManagement.feature.student.services

import com.example.studentManagement.entities.StudentEntity
import com.example.studentManagement.models.StudentDTO
import com.example.studentManagement.models.StudentList
import com.example.studentManagement.models.StudentUpdateInfoDTO
import com.example.studentManagement.models.StudentWithIdDTO
import com.google.cloud.Timestamp

interface IStudentServices {
    fun createStudent(studentInfo: StudentDTO): StudentEntity
    fun getStudentList() : StudentList
    fun updateStudentInfo(studentInfo: StudentUpdateInfoDTO): Timestamp?
    fun disableStudent(studentID: String) : Timestamp?

}