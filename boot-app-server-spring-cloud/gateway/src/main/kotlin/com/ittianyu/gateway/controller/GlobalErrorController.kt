package com.ittianyu.gateway.controller

import com.ittianyu.common.bo.ResultEnum
import com.ittianyu.common.dto.ResultDTO
import com.ittianyu.common.web.utils.ResultFactory
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.servlet.support.RequestContextUtils
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

private const val ERROR_PATH = "/error"

@RestController
class GlobalErrorController @Autowired constructor(val messageSource: MessageSource) : ErrorController {
    val log = LoggerFactory.getLogger(javaClass)

    override fun getErrorPath(): String {
        return ERROR_PATH
    }

    @RequestMapping(ERROR_PATH)
    fun error(request: HttpServletRequest, response: HttpServletResponse): ResultDTO<Void> {
        val statusCode = request.getAttribute("javax.servlet.error.status_code") as Int
        val errorAttr = getErrorAttributes(request, DefaultErrorAttributes(), true)
        log.info(errorAttr.toString())
        // try to get message from i18n config
        val message = errorAttr["message"]?.toString()
        if (message != null) {
            val i18nMsg = try {
                messageSource.getMessage(message, null, null, RequestContextUtils.getLocale(request))
            } catch (e: Exception) {
                null
            }
            if (i18nMsg != null) {
                return ResultFactory.error(ResultEnum.UNKNOWN.code, i18nMsg)
            }
        }

        // return default message
        return when (statusCode) {
            404, 405 -> {
                ResultFactory.from<Void>(request, ResultEnum.PAGE_NOT_FOUND)
            }
            else -> {
                ResultFactory.from<Void>(request, ResultEnum.UNKNOWN)
            }
        }
    }

    protected fun getErrorAttributes(request: HttpServletRequest,
                                     errorAttributes: ErrorAttributes,
                                     includeStackTrace: Boolean): Map<String, Any> {
        val requestAttributes = ServletWebRequest(request)
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace)
    }

}
