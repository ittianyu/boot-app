package com.ittianyu.dashboardapi.dto

data class DashboardConfigItemConfigDTO(
        var type: String? = null,
        var param: Map<String, Any>? = null,
        var default: Boolean = false
)
