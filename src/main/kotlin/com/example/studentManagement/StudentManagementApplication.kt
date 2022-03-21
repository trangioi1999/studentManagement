package com.example.studentManagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class StudentManagementApplication

fun main(args: Array<String>) {
	runApplication<StudentManagementApplication>(*args)
}
