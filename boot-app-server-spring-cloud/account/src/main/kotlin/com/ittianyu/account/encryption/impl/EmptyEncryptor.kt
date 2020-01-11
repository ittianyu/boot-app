package com.ittianyu.account.encryption.impl

import com.ittianyu.account.encryption.Encryptor

class EmptyEncryptor : Encryptor {
    override fun encrypt(source: String?, config: String?): String? {
        return source;
    }
}
