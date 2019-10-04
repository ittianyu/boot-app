package com.ittianyu.common.web.utils

import com.ittianyu.common.utils.JsonUtils
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import java.io.IOException
import javax.servlet.http.HttpServletResponse

object ResponseUtils {
    private val log = LoggerFactory.getLogger(ResponseUtils::class.java)

    fun writeBean(response: HttpServletResponse, o: Any,
                  status: Int = HttpStatus.OK.value(),
                  contentType: String = MediaType.APPLICATION_JSON_VALUE,
                  encoding: String = "UTF-8",
                  cache: Boolean = false) {
        response.status = status
        response.contentType = contentType
        response.characterEncoding = encoding
        if (!cache) {
            response.setHeader("Cache-Control", "no-cache, must-revalidate")
        }
        val writer = response.writer
        try {
            writer.write(JsonUtils.toJson(o)!!)
        } catch (e: IOException) {
            log.error(e.message, e)
        } finally {
            writer.close()
        }
    }

}
