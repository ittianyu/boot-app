package com.ittianyu.dashboard.service

import org.springframework.transaction.annotation.Transactional

interface ConfigService {

    fun set(key: String, value: String)

    fun <T> set(config: Map<String, T>)

    fun get(key: String, defaultValue: String? = null): String?

    fun remove(key: String)
}
