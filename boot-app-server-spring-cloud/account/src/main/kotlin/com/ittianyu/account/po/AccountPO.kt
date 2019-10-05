package com.ittianyu.account.po

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "account")
data class AccountPO(
        @Id
        @GeneratedValue
        var id: Int? = null,
        @Column(unique = true)
        var username: String = "",
        var nickname: String = "",
        var password: String = "",
        var status: Byte = 0,
        var token: String = "",
        var tokenExpireTime: Long = 0,
        var createdTime: Long = 0,
        var updatedTime: Long = 0
)
