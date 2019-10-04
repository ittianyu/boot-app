package com.ittianyu.common.web.utils

import com.ittianyu.common.bo.ResultEnum
import com.ittianyu.common.bo.ResultException
import com.ittianyu.common.dto.ResultDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Component
import org.springframework.web.servlet.support.RequestContextUtils
import javax.servlet.http.HttpServletRequest

@Component
object ResultFactory {
    private val log = LoggerFactory.getLogger(ResultDTO::class.java)
    private val RESULT_OK = ResultDTO<Void>(ResultEnum.OK.code)

    @Autowired
    private var messageSource: MessageSource? = null

    fun <T> success(data: T?, message: String? = null): ResultDTO<T> {
        return ResultDTO(ResultEnum.OK.code, message, data)
    }

    fun success(): ResultDTO<Void> {
        return RESULT_OK
    }

    fun <T> successI18n(request: HttpServletRequest, data: T?, message: String? = null): ResultDTO<T> {
        if (null == message) {
            return ResultDTO(ResultEnum.OK.code, message, data)
        }

        val i18nMsg = try {
            messageSource!!.getMessage(message, null, RequestContextUtils.getLocale(request))
        } catch (e: Exception) {
            log.warn(e.message)
            message
        }
        return ResultDTO(ResultEnum.OK.code, i18nMsg, data)
    }

    fun <T> error(code: Int, message: String? = null): ResultDTO<T> {
        return ResultDTO(code, message)
    }

    fun <T> errorI18n(request: HttpServletRequest, code: Int, message: String? = null): ResultDTO<T> {
        if (message == null) {
            return ResultDTO(code)
        }

        val i18nMsg = try {
            messageSource!!.getMessage(message, null, RequestContextUtils.getLocale(request))
        } catch (e: Exception) {
            log.warn(e.message)
            message
        }
        return ResultDTO(code, i18nMsg)
    }

    /**
     * copy code message and data from a exist Result
     * data will be empty if use misclassification
     */
    fun <T> from(source: ResultDTO<*>): ResultDTO<T> {
        if (source.isSuccess()) {
            val data: T? = try {
                if (source.data != null) source.data as T else null
            } catch (e: Exception) {
                log.error("from", e)
                null
            }
            return success(data, source.message)
        }
        return error(source.code, source.message)
    }

    fun <T> from(request: HttpServletRequest, source: ResultEnum): ResultDTO<T> {
        return errorI18n(request, source.code, source.message)
    }

    fun <T> from(request: HttpServletRequest, source: ResultException): ResultDTO<T> {
        return errorI18n(request, source.code, source.message)
    }

}