package com.ittianyu.account.service

import com.ittianyu.account.po.AccountPO
import com.ittianyu.accountapi.dto.AuthDTO
import com.ittianyu.accountapi.dto.AuthResultDTO
import com.ittianyu.accountapi.dto.LoginResultDTO
import com.ittianyu.accountapi.dto.LoginDTO
import com.ittianyu.common.dto.ResultDTO

interface AccountService {
    fun register(account: AccountPO): ResultDTO<Void>
    fun login(data: LoginDTO): ResultDTO<LoginResultDTO>
    fun auth(data: AuthDTO): ResultDTO<AuthResultDTO>
}
