package com.example.studentManagement.feature.student

import com.example.studentManagement.feature.student.services.IStudentServices
import com.example.studentManagement.models.StudentDTO
import com.example.studentManagement.models.StudentUpdateInfoDTO
import com.example.studentManagement.models.UpdateTime
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
@RequestMapping("/student")
class StudentController(
    @Autowired val studentServices: IStudentServices
) {
    val logger = LoggerFactory.getLogger(StudentController::class.java)!!

    @PostMapping
    fun createStudent(@RequestBody studentInfo: StudentDTO) : ResponseEntity<Any> {
        return ResponseEntity.ok(studentServices.createStudent(studentInfo))
    }
    @GetMapping
    fun getStudentList() : ResponseEntity<Any> {
        return ResponseEntity.ok(studentServices.getStudentList())
    }

    @PutMapping
    fun updateStudentInfo(@RequestBody studentInfo: StudentUpdateInfoDTO) : ResponseEntity<Any> {
        return ResponseEntity.ok(UpdateTime(studentServices.updateStudentInfo(studentInfo)!!.seconds))
    }

    @DeleteMapping
    fun disableStudent(@RequestParam id: String) : ResponseEntity<Any> {
        return ResponseEntity.ok(UpdateTime(studentServices.disableStudent(id)!!.seconds))
    }

}