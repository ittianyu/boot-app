package com.ittianyu.dashboard.service.impl

import com.ittianyu.dashboard.po.ConfigPO
import com.ittianyu.dashboard.repository.ConfigRepository
import com.ittianyu.dashboard.service.ConfigService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ConfigServiceImpl @Autowired constructor(private val configRepository: ConfigRepository) : ConfigService {

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
