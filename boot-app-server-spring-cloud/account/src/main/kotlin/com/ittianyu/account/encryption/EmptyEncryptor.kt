package com.ittianyu.account.encryption

class EmptyEncryptor : Encryptor {
    override fun encrypt(source: String?, config: String?): String? {
        return source;
    }
}
