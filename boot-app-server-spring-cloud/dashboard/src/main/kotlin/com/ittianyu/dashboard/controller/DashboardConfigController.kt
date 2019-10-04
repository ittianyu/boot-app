package com.ittianyu.dashboard.controller

import com.ittianyu.common.dto.ResultDTO
import com.ittianyu.common.utils.JsonUtils
import com.ittianyu.common.web.utils.ResultFactory
import com.ittianyu.dashboard.po.ConfigPO
import com.ittianyu.dashboard.service.ConfigService
import com.ittianyu.dashboardapi.api.DashboardConfigApi
import com.ittianyu.dashboardapi.dto.DashboardConfigItemDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/config"])
class DashboardConfigController @Autowired constructor(private val configService: ConfigService) : DashboardConfigApi {

    override fun get(name: String): ResultDTO<DashboardConfigItemDTO> {
        throw RuntimeException("test exception")
        return ResultFactory.success(JsonUtils.fromJson(configService.get(name), DashboardConfigItemDTO::class.java))
    }

    @PostMapping(path = ["/set"])
    fun set(@Valid @RequestBody config: ConfigPO): ResultDTO<Void> {
        configService.set(config.key!!, config.value!!)
        return ResultFactory.success()
    }
}
