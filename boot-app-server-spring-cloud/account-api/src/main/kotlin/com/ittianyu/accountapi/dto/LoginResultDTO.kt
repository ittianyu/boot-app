package com.ittianyu.accountapi.dto

/**
 * login result
 */
data class LoginResultDTO(
        var username: String? = null,
        var nickname: String? = null,
        var status: Byte? = null,
        var token: String? = null,
        var tokenExpireTime: Long? = null
) {
}
