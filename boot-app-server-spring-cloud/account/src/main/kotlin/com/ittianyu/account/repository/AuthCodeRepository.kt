package com.ittianyu.account.repository

import com.ittianyu.account.po.AuthCodePO
import org.springframework.data.jpa.repository.JpaRepository

interface AuthCodeRepository : JpaRepository<AuthCodePO, Int> {

}
