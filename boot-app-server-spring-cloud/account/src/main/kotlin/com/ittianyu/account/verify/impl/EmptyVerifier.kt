package com.ittianyu.account.verify.impl

import com.ittianyu.account.verify.Verifier

/**
 * always pass
 */
class EmptyVerifier: Verifier {
    override fun sendKey(param: String, username: String): String? {
        return null
    }

    override fun verify(param: String, username: String, code: String): Boolean {
        return true
    }
}
