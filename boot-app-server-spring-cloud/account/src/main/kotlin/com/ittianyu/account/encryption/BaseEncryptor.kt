package com.ittianyu.account.encryption

import com.ittianyu.accountapi.dto.EncryptionAlgorithmConfigDTO
import com.ittianyu.common.utils.JsonUtils

abstract class BaseEncryptor: Encryptor {

    override fun encrypt(source: String?, config: String?): String? {
        source ?: return null
        val baseConfig = JsonUtils.fromJson(config, EncryptionAlgorithmConfigDTO::class.java)
        baseConfig ?: return null
        return encrypt(source, baseConfig)
    }

    abstract fun encrypt(source: String, config: EncryptionAlgorithmConfigDTO): String?
}
