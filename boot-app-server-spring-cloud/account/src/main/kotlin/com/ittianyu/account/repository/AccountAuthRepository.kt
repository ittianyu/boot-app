package com.ittianyu.account.repository

import com.ittianyu.account.po.AccountAuthPO
import org.springframework.data.jpa.repository.JpaRepository

interface AccountAuthRepository : JpaRepository<AccountAuthPO, Int> {

}
