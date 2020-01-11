package com.ittianyu.dashboardapi.service

import com.ittianyu.common.dto.ResultDTO
import com.ittianyu.dashboardapi.dto.DashboardConfigItemDTO

interface DashboardConfigService {
    fun refresh()
    fun get(name: String): ResultDTO<DashboardConfigItemDTO>
}
