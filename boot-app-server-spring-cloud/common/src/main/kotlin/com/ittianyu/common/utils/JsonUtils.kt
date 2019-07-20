package com.ittianyu.common.utils


import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory

object JsonUtils {
    private val log = LoggerFactory.getLogger(javaClass)

    private val MAPPER = ObjectMapper()

    /**
     * pojo to json
     *
     * @param bean
     * @return
     */
    fun toJson(bean: Any?): String? {
        bean ?: return null
        try {
            return MAPPER.writeValueAsString(bean)
        } catch (e: JsonProcessingException) {
            log.error("toJson", e)
        }
        return null
    }

    /**
     * json to pojo
     *
     * @param json
     * @param beanType
     * @return
     */
    fun <T> fromJson(json: String?, beanType: Class<T>): T? {
        json ?: return null
        try {
            return MAPPER.readValue(json, beanType)
        } catch (e: Exception) {
            log.error("fromJson", e)
        }
        return null
    }

    /**
     * json to List<pojo>
     *
     * @param json
     * @param beanType
     * @return
     */
    fun <T> fromJsonToList(json: String?, beanType: Class<T>): List<T>? {
        json ?: return null
        val javaType = MAPPER.typeFactory.constructParametricType(List::class.java, beanType)
        try {
            return MAPPER.readValue<List<T>>(json, javaType)
        } catch (e: Exception) {
            log.error("fromJsonToList", e)
        }
        return null
    }

}
