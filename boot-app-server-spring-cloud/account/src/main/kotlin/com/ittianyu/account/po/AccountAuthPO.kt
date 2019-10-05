package com.ittianyu.account.po

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "account_auth")
data class AccountAuthPO(
        @Id
        @GeneratedValue
        var id: Int? = null,
        var accountId: Int = 0,
        var verifyType: Int = 0,
        var verifyAccount: String = "",
        var verifyCode: String = ""
) {
}
