package com.ittianyu.dashboardapi.dto

import java.io.Serializable

data class DashboardConfigItemDTO(
        var i18n: String? = null,
        var type: Map<String, DashboardConfigItemTypeDTO>? = null,
        var config: DashboardConfigItemConfigDTO? = null
) : Serializable
