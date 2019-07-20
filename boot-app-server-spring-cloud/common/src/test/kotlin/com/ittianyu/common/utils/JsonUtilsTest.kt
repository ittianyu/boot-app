package com.ittianyu.common.utils

import org.junit.Test

import org.junit.Assert.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JsonUtilsTest {

    data class User(var id: Int = 0, var firstName: String? = null, var surName: String? = null)

    @Test
    fun toJson() {
        val bean = User(1, "Jack", "Michael")
        val expected = """{"id":${bean.id},"firstName":"${bean.firstName}","surName":"${bean.surName}"}"""
        val actual = JsonUtils.toJson(bean)
        println(actual)
        assertEquals(expected, actual)
    }

    @Test
    fun fromJson() {
        val expected = User(1, "Jack", "Michael")
        val json = """{"id":${expected.id},"firstName":"${expected.firstName}","surName":"${expected.surName}"}"""
        val actual = JsonUtils.fromJson(json, User::class.java)
        println(actual)
        assertEquals(expected, actual)
    }

    @Test
    fun fromJsonToList() {
        val expected = listOf(
                User(1, "Jack", "Michael"),
                User(2, "Tom", "Michael")
        )
        val json = JsonUtils.toJson(expected)
        val actual = JsonUtils.fromJsonToList(json, User::class.java)
        println(actual)
        assertEquals(expected, actual)
    }
}
