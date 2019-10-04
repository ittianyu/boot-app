package com.ittianyu.common.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.ittianyu.common.bo.ResultEnum
import com.ittianyu.common.bo.ResultException
import org.slf4j.LoggerFactory
import java.io.Serializable

/**
 * common transfer object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResultDTO<T>(val code: Int = ResultEnum.OK.code,
                        val message: String? = null,
                        val data: T? = null) : Serializable {

    @JsonIgnore
    fun isSuccess(): Boolean {
        return code == ResultEnum.OK.code
    }

}
