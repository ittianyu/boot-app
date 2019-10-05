package com.ittianyu.accountapi.dto

import javax.validation.constraints.NotEmpty

/**
 * auth params
 */
data class AuthDTO(
        @field:NotEmpty(message = "empty.field")
        var token: String? = null
) {
}
