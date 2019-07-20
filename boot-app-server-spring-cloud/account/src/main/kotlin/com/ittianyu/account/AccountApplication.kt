package com.ittianyu.account

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
class AccountApplication

fun main(args: Array<String>) {
    runApplication<AccountApplication>(*args)
}
