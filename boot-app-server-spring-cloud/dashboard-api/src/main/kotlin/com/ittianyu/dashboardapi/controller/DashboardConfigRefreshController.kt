package com.ittianyu.dashboardapi.controller

import com.ittianyu.common.dto.ResultDTO
import com.ittianyu.common.web.utils.ResultFactory
import com.ittianyu.dashboardapi.api.DashboardConfigRefreshApi
import com.ittianyu.dashboardapi.service.DashboardConfigService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * used for refresh config
 */
@RestController
@RequestMapping(path = ["/config"])
class DashboardConfigRefreshController @Autowired constructor(private val dashboardConfigService: DashboardConfigService) : DashboardConfigRefreshApi {
    override fun refresh(): ResultDTO<Void> {
        dashboardConfigService.refresh()
        return ResultFactory.success()
    }
}
