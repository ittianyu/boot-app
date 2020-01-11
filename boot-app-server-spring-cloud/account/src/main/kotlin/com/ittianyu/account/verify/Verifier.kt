package com.ittianyu.account.verify

import com.ittianyu.dashboardapi.config.Configurable

interface Verifier: Configurable {
    /**
     * send or generate a secret key before verifying
     */
    fun sendKey(username: String): String?

    /**
     * check whether user input code is correct
     */
    fun verify(username: String, code: String): Boolean
}
