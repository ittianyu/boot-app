package com.ittianyu.common.bo

import java.lang.RuntimeException

class ResultException(val code: Int, message: String? = null) : RuntimeException(message) {

}