package com.example.studentManagement.feature.student.services

import com.example.studentManagement.entities.StudentEntity
import com.example.studentManagement.feature.student.repositories.IStudentRepositories
import com.example.studentManagement.models.StudentDTO
import com.example.studentManagement.models.StudentList
import com.example.studentManagement.models.StudentUpdateInfoDTO
import com.example.studentManagement.models.StudentWithIdDTO
import com.google.cloud.Timestamp
import org.springframework.stereotype.Service

@Service
class StudentServices(val stuRepo: IStudentRepositories) : IStudentServices {

    override fun createStudent(studentInfo: StudentDTO): StudentEntity {
       return stuRepo.createStudent(studentInfo)
    }

    override fun getStudentList(): StudentList {
       return stuRepo.getStudentList()
    }

    override fun updateStudentInfo(studentInfo: StudentUpdateInfoDTO): Timestamp? {
      return stuRepo.updateStudentInfo(studentInfo)
    }

    override fun disableStudent(studentID: String): Timestamp? {
       return stuRepo.disableStudent(studentID)
    }


}