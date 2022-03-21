package com.example.studentManagement.feature.student.repositories

import com.example.studentManagement.entities.StudentEntity
import com.example.studentManagement.models.StudentDTO
import com.example.studentManagement.models.StudentList
import com.example.studentManagement.models.StudentUpdateInfoDTO
import com.example.studentManagement.models.StudentWithIdDTO
import com.example.studentManagement.utils.RandomUtils
import com.google.cloud.Timestamp
import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.Query.Direction
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class StudentRepositories(@Autowired db: Firestore) : IStudentRepositories{
    val stuColRef: CollectionReference = db.collection("student")
    val logger = LoggerFactory.getLogger(StudentRepositories::class.java)!!

    override fun createStudent(studentInfo: StudentDTO): StudentEntity {
        val stuData = StudentEntity(
            studentID = RandomUtils.generateStudentID(),
            studentName = studentInfo.studentName,
            studentClass = studentInfo.studentClass,
            studentAccountActive = true,
        )
        stuColRef.document(stuData.studentID).set(stuData)
       return stuData

    }

    override fun getStudentList(): StudentList {
        val query = stuColRef
            .orderBy("studentID", Direction.ASCENDING)
            .orderBy("studentName",Direction.ASCENDING).get().get()
        val data : ArrayList<StudentWithIdDTO> = ArrayList()
       query.forEach {
           data.add(it.toObject(StudentWithIdDTO::class.java))
       }
        return StudentList(
            studentList = data
        )

    }

    override fun updateStudentInfo(studentInfo : StudentUpdateInfoDTO): Timestamp? {
        val stuID = studentInfo.studentID
        logger.info("id: $stuID")
        return stuColRef.document(stuID).set(studentInfo).get().updateTime

        }

    override fun disableStudent(studentID: String): Timestamp? {
        return stuColRef.document(studentID).update("studentAccountActive", false).get().updateTime

    }

}


