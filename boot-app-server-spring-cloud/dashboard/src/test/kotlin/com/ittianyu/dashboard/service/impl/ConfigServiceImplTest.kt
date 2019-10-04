package com.ittianyu.dashboard.service.impl

import com.ittianyu.dashboard.DashboardApplicationTests
import com.ittianyu.dashboard.service.ConfigService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ConfigServiceImplTest {
    @Autowired
    private var configService: ConfigService? = null

    private val KEY = "test"
    private val VALUE = """{"id": "name", "value": "ok"}"""

    @Test
    fun testAll() {
        configService ?: return
        println("start")

        // set value
        configService?.set(KEY, VALUE)

        var value = configService?.get(KEY)
        Assert.assertEquals(VALUE, value)

        configService?.remove(KEY)

        value = configService?.get(KEY)
        Assert.assertTrue(value == null)
    }
}
