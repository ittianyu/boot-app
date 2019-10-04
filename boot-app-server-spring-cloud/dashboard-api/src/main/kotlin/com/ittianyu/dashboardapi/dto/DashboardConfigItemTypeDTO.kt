package com.ittianyu.dashboardapi.dto

data class DashboardConfigItemTypeDTO(
        var i18n: String? = null,
        var clazz: String? = null,
        var param: Map<String, Any>? = null
)
