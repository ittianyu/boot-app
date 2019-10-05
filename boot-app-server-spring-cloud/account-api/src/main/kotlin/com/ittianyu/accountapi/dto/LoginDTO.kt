package com.ittianyu.accountapi.dto

import javax.validation.constraints.NotEmpty

/**
 * login params
 */
data class LoginDTO(
        @field:NotEmpty(message = "empty.field")
        var username: String? = null,
        @field:NotEmpty(message = "empty.field")
        var password: String? = null,
        var code: String? = null
) {
}
