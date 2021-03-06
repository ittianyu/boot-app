package com.ittianyu.dashboard.service.impl

import com.ittianyu.common.utils.JsonUtils
import com.ittianyu.dashboard.po.ConfigPO
import com.ittianyu.dashboard.repository.ConfigRepository
import com.ittianyu.dashboard.service.ConfigService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ConfigServiceImpl @Autowired constructor(private val configRepository: ConfigRepository) : ConfigService {

    @Transactional
    override fun <T> set(config: Map<String, T>) {
        config.forEach {
            set(it.key, JsonUtils.toJson(it.value)!!)
        }
    }

    override fun get(key: String, defaultValue: String?): String? {
        val optional = configRepository.findById(key)
        if (optional.isPresent) {
            return optional.get().value
        }
        return defaultValue
    }

    override fun set(key: String, value: String) {
        configRepository.save(ConfigPO(key, value))
    }

    override fun remove(key: String) {
        configRepository.delete(ConfigPO(key))
    }

}
