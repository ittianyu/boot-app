package com.ittianyu.common.web.handler

import com.ittianyu.common.bo.ResultEnum
import com.ittianyu.common.bo.ResultException
import com.ittianyu.common.web.utils.ResponseUtils
import com.ittianyu.common.web.utils.ResultFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class GlobalExceptionResolver : HandlerExceptionResolver {
    val log = LoggerFactory.getLogger(javaClass)

    override fun resolveException(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  handler: Any?, ex: Exception): ModelAndView? {
        log.error(ex.message, ex)
        if (ex is ResultException) {
            ResponseUtils.writeBean(response, ResultFactory.from<Void>(request, ex))
        } else {
            ResponseUtils.writeBean(response, ResultFactory.from<Void>(request, ResultEnum.UNKNOWN))
        }

        return MV
    }

    companion object {
        private val MV = ModelAndView()
    }
}
