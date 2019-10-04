package com.ittianyu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class DiscoverApplication

fun main(args: Array<String>) {
    runApplication<DiscoverApplication>(*args)
}
