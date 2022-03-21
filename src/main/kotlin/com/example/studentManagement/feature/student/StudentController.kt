package com.example.studentManagement.feature.student

import com.example.studentManagement.feature.student.services.IStudentServices
import com.example.studentManagement.models.StudentDTO
import com.example.studentManagement.models.StudentUpdateInfoDTO
import com.example.studentManagement.models.UpdateTime
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()
class StudentController(
    @Autowired val studentServices: IStudentServices
) {
    val logger = LoggerFactory.getLogger(StudentController::class.java)!!

    @PostMapping("/student")
    fun createStudent(@RequestBody studentInfo: StudentDTO) : ResponseEntity<Any> {
        return ResponseEntity.ok(studentServices.createStudent(studentInfo))
    }
    @GetMapping("/student")
    fun getStudentList() : ResponseEntity<Any> {
        return ResponseEntity.ok(studentServices.getStudentList())
    }

    @PutMapping("/student")
    fun updateStudentInfo(@RequestBody studentInfo: StudentUpdateInfoDTO) : ResponseEntity<Any> {
        return ResponseEntity.ok(UpdateTime(studentServices.updateStudentInfo(studentInfo)!!.seconds))
    }

    @DeleteMapping("/student")
    fun disableStudent(@RequestParam id: String) : ResponseEntity<Any> {
        return ResponseEntity.ok(UpdateTime(studentServices.disableStudent(id)!!.seconds))
    }

}