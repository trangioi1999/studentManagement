package com.example.studentManagement.entities
import org.apache.commons.lang3.StringUtils.EMPTY

class StudentEntity (
    val studentID : String,
    val studentName : String ,
    val studentClass : String,
    val studentAccountActive : Boolean
)