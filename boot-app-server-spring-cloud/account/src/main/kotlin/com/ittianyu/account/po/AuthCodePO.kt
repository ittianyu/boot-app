package com.ittianyu.account.po

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "auth_code")
data class AuthCodePO(
        @Id
        @GeneratedValue
        var id: Int? = null,
        @Column(unique = true)
        var code: String = "",
        var used: Boolean = false,
        var version: Int = 0
) {
}
