package com.ittianyu.account.encryption

import com.ittianyu.account.encryption.utils.EncryptionUtils
import com.ittianyu.accountapi.dto.EncryptionAlgorithmConfigDTO

class MD5Encryptor : BaseEncryptor() {
    override fun encrypt(source: String, config: EncryptionAlgorithmConfigDTO): String? {
        return EncryptionUtils.MD5N(source, config.salt, config.count)
    }
}
