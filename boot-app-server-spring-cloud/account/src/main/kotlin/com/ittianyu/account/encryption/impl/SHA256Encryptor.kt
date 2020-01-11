package com.ittianyu.account.encryption.impl

import com.ittianyu.account.encryption.utils.EncryptionUtils
import com.ittianyu.accountapi.dto.EncryptionAlgorithmConfigDTO

class SHA256Encryptor : BaseEncryptor() {
    override fun encrypt(source: String, config: EncryptionAlgorithmConfigDTO): String? {
        return EncryptionUtils.SHA256N(source, config.salt, config.count)
    }
}
