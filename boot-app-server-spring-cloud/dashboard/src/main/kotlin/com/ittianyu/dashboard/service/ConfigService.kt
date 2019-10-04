package com.ittianyu.dashboard.service

interface ConfigService {

    fun set(key: String, value: String)

    fun get(key: String, defaultValue: String? = null): String?

    fun remove(key: String)
}
