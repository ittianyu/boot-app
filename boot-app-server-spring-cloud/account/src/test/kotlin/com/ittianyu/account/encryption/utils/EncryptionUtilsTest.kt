package com.ittianyu.account.encryption.utils

import com.ittianyu.common.CommonApplication
import org.junit.Test

import org.junit.Assert.*
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class EncryptionUtilsTest {

    @Test
    fun MD5() {
        var actual: String?
        var expected: String?
        // MD5 hello
        actual = EncryptionUtils.MD5("hello")
        expected = "5d41402abc4b2a76b9719d911017c592"
        assertEquals(expected, actual)

        // MD5 hello with salt "abc"
        actual = EncryptionUtils.MD5("hello", "abc")
        expected = "d76051e1dae76d1f309598102df58d84"
        assertEquals(expected, actual)
    }

    @Test
    fun MD5N() {
        var actual: String?
        var expected: String?
        // MD5N("hello", count=3)
        actual = EncryptionUtils.MD5N("hello", count=3)
        expected = "0dcd649d4ef5f787e39ddf48d8e625a5"
        assertEquals(expected, actual)

        // MD5N("hello", salt="abc", count=3)
        actual = EncryptionUtils.MD5N("hello", "abc", 3)
        expected = "055512751de80fab1f2c65d7a34d92de"
        assertEquals(expected, actual)

        // MD5N("hello", count=0)
        actual = EncryptionUtils.MD5N("world", count = -1)
        expected = "world"
        assertEquals(expected, actual)
    }

    @Test
    fun md5File() {
        // normal branch
        val path = javaClass.classLoader.getResource("application.properties")?: return
        val actual = EncryptionUtils.MD5File(File(path.file))
        val expected = "68B329DA9893E34099C7D8AD5CB9C940".toLowerCase()
        assertEquals(expected, actual)

        // file not exist
        try {
            EncryptionUtils.MD5File(File("not exist"))
            assert(false)
        } catch (e: Exception) {
            assert(true)
        }
    }

    @Test
    fun SHA256() {
        var actual: String?
        var expected: String?
        // SHA256 hello
        actual = EncryptionUtils.SHA256("hello")
        expected = "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824"
        assertEquals(expected, actual)

        // SHA256 hello with salt "abc"
        actual = EncryptionUtils.SHA256("hello", "abc")
        expected = "2cb9c710242d0e384bb068a76a664a10f3970c7e81d58059378cfd5f5ba12b0f"
        assertEquals(expected, actual)
    }

    @Test
    fun SHA256N() {
        var actual: String?
        var expected: String?
        // SHA256N("hello", count=3)
        actual = EncryptionUtils.SHA256N("hello", count=3)
        expected = "ecd26292b7f02970ca6909abb23e1aedd0dd57d0ee9ff40bf3f30c325e3e453a"
        assertEquals(expected, actual)

        // SHA256N("hello", salt="abc", count=3)
        actual = EncryptionUtils.SHA256N("hello", "abc", 3)
        expected = "408fee335aa9cac28bef1e26926d7459a425300851101901334ca58c7e133763"
        assertEquals(expected, actual)

        // SHA256N("hello", count=0)
        actual = EncryptionUtils.SHA256N("world", count = -1)
        expected = "world"
        assertEquals(expected, actual)
    }
}
