package com.ittianyu.account.service.impl

import com.ittianyu.account.po.AccountPO
import com.ittianyu.account.service.AccountService
import com.ittianyu.accountapi.dto.AuthDTO
import com.ittianyu.accountapi.dto.AuthResultDTO
import com.ittianyu.accountapi.dto.LoginDTO
import com.ittianyu.accountapi.dto.LoginResultDTO
import com.ittianyu.common.dto.ResultDTO
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl : AccountService {
    override fun register(account: AccountPO): ResultDTO<Void> {
        
    }

    override fun login(data: LoginDTO): ResultDTO<LoginResultDTO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun auth(data: AuthDTO): ResultDTO<AuthResultDTO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}