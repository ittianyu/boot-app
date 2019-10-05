package com.ittianyu.account.repository

import com.ittianyu.account.po.AccountPO
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountPO, Int> {

}
