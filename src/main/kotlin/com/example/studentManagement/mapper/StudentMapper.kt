package com.example.studentManagement.mapper

import com.example.studentManagement.entities.StudentEntity
import com.example.studentManagement.models.StudentDTO
import com.example.studentManagement.models.StudentWithIdDTO

class StudentMapper {

    fun StudentWithIdDTO.toStudentEntity(): StudentEntity {
        return StudentEntity(
            studentID = this.studentID,
            studentName = this.studentName,
            studentClass = this.studentClass,
            studentAccountActive = true
        )
    }
}