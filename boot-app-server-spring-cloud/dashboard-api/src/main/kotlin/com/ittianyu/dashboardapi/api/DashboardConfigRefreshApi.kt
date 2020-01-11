package com.ittianyu.dashboardapi.api

import com.ittianyu.common.dto.ResultDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "dashboard", path = "/config", contextId = "dashboardConfigRefreshApi")
interface DashboardConfigRefreshApi {
    @GetMapping(path = ["/refresh"])
    fun refresh(): ResultDTO<Void>
}
