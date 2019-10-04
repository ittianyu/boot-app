package com.ittianyu.dashboardapi.api

import com.ittianyu.common.dto.ResultDTO
import com.ittianyu.dashboardapi.dto.DashboardConfigItemDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "dashboard", path = "/config", contextId = "dashboardConfigApi")
interface DashboardConfigApi {
    @GetMapping(path = ["/get"])
    fun get(name: String): ResultDTO<DashboardConfigItemDTO>
}
