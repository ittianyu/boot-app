package com.ittianyu.account

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/test")
@RestController
class TestController {

    @RequestMapping("/hello")
    fun create(): String {
        Thread.sleep(1000)
        return "hello world"
    }

}