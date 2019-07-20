package com.ittianyu.account.encryption

interface Encryptor {
    fun encrypt(source: String?, config: String?): String?
}
