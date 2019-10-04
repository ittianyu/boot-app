package com.ittianyu.dashboard.controller

import com.ittianyu.common.utils.JsonUtils
import com.ittianyu.dashboardapi.dto.DashboardConfigItemDTO
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DashboardConfigControllerTest {

    @Autowired
    var dashboardConfigController: DashboardConfigController? = null

    var config: Map<String, DashboardConfigItemDTO>? = null

    @Before
    fun prepareData() {
        val reader = javaClass.classLoader.getResourceAsStream("config/dashboard_config_account.json")
                .bufferedReader()
        val json = reader.readText()
        reader.close()

        assertNotNull(json)

        config = JsonUtils.fromJsonToMap(json, DashboardConfigItemDTO::class.java)
        assertNotNull(config)
    }

    @Test
    fun get() {
        config!!.forEach {
            val actual = dashboardConfigController!!.get(it.key)
            assertEquals(it.value, actual.data)
        }
    }

    @Test
    fun set() {
        dashboardConfigController!!.set(config!!)
    }

}
