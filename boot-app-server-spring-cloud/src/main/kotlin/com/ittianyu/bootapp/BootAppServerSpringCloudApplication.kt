package com.ittianyu.bootapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootAppServerSpringCloudApplication

fun main(args: Array<String>) {
    runApplication<BootAppServerSpringCloudApplication>(*args)
}
