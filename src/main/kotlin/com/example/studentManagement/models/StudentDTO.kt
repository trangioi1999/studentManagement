package com.example.studentManagement.models

import org.apache.commons.lang3.StringUtils.EMPTY

data class StudentDTO(
    val studentName: String,
    val studentClass: String
)
data class StudentUpdateInfoDTO(
    val studentID: String,
    val studentName: String,
    val studentClass: String
)
class StudentWithIdDTO {
    val studentID: String = EMPTY
    val studentName: String = EMPTY
    val studentClass: String = EMPTY
    val studentAccountActive: Boolean = true
}
data class StudentList(
    val studentList: ArrayList<StudentWithIdDTO>
)
