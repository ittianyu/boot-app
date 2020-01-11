package com.ittianyu.dashboardapi.service.impl

import com.ittianyu.common.dto.ResultDTO
import com.ittianyu.dashboardapi.api.DashboardConfigApi
import com.ittianyu.dashboardapi.dto.DashboardConfigItemDTO
import com.ittianyu.dashboardapi.service.DashboardConfigService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class DashboardConfigServiceImpl @Autowired constructor(private val dashboardConfigApi: DashboardConfigApi) : DashboardConfigService {
    private val configCacheMap: MutableMap<String, ResultDTO<DashboardConfigItemDTO>> = ConcurrentHashMap()

    override fun refresh() {
        configCacheMap.clear()
    }

    override fun get(name: String): ResultDTO<DashboardConfigItemDTO> {
        var value = configCacheMap[name]
        if (value != null) {
            return value
        }
        value = dashboardConfigApi.get(name)
        configCacheMap[name] = value
        return value
    }

}
