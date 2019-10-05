package com.ittianyu.accountapi.dto

/**
 * auth result
 */
data class AuthResultDTO(
        var username: String? = null,
        var nickname: String? = null,
        var status: Byte? = null
) {
}
