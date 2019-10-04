package com.ittianyu.common.bo

enum class ResultEnum(val code: Int, val message: String?) {
    OK(0, null),
    NOT_LOGIN(401, "result.notLogin"),
    INVALID_REQUEST(402, "result.invalidRequest"),
    PAGE_NOT_FOUND(404, "result.pageNotFound"),
    UNKNOWN(500, "result.unknown"),
}
