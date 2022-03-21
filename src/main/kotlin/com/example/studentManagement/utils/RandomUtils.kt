package com.example.studentManagement.utils

import kotlin.random.Random

class RandomUtils {
    companion object {
        private val base62Chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            .toCharArray()
        private const val randomLength = 6

        fun generateStudentID(): String{
            return RandomPrefix.USER.prefix + genRandom(10)
        }

        private fun genRandom(threadHold : Int): String {
            val randomID = StringBuilder(randomLength)
            repeat(randomLength){
                randomID.append(base62Chars[Random.nextInt(threadHold)]).toString()
            }
            return randomID.toString()
        }
    }
}
enum class RandomPrefix(val prefix: String){
    USER("ID"),
    SALE("SALE"),
    COLOR("COLOR")
}