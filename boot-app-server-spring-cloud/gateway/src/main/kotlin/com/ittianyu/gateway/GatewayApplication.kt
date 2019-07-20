package com.ittianyu.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableZuulProxy
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
class GatewayApplication

fun main(args: Array<String>) {
    runApplication<GatewayApplication>(*args)
}
