package com.ittianyu.account.verify.impl

import com.ittianyu.account.verify.Verifier
import com.ittianyu.common.utils.JsonUtils
import org.gradle.internal.impldep.com.google.api.client.http.UrlEncodedContent.getContent
import org.slf4j.LoggerFactory
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.mail.javamail.MimeMessageHelper


/**
 * send a code to email and verify user input
 */
class EmailVerifier : Verifier {
    private val log = LoggerFactory.getLogger(javaClass)
    private val mailSender: JavaMailSenderImpl = JavaMailSenderImpl()
    private val config: Param? = null

    @Synchronized override fun setConfig(configString: String) {
        config = JsonUtils.fromJson(configString, Param::class.java) ?: return
        mailSender.host = config.host
        mailSender.port = config.port
        mailSender.username = config.username
        mailSender.password = config.password
        mailSender.defaultEncoding = config.encoding
    }

    override fun sendKey(username: String): String? {
        try {
            val message = mailSender.createMimeMessage()
            val helper = MimeMessageHelper(message, true)
            helper.setFrom(config.username)
            helper.setTo(username)
            helper.setSubject(config.title)
            val code = 1000// todo generate code
            helper.setText(String.format(config.content, code), false)

            mailSender.send(message)
        } catch (e: Exception) {
            log.error("sendKey", e)
        }

        return null
    }

    override fun verify(username: String, code: String): Boolean {
        return true
    }

    private data class Param(
            var title: String? = "verify.title",
            var content: String? = "verify.content",
            var host: String? = null,
            var port: Int = 465,
            var username: String? = null,
            var password: String? = null,
            var encoding: String? = "UTF-8"
    )
}
