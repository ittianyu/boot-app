package com.ittianyu.account.encryption.utils


import org.slf4j.LoggerFactory
import java.io.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Encryption utils, such as MD5 sha256
 */
object EncryptionUtils {
    private val log = LoggerFactory.getLogger(javaClass)

    private const val CHARSET_UTF8 = "UTF-8"

    /**
     * use MD5 algorithm
     *
     * @param source the String need to encrypt
     * @return the encrypted result
     */
    fun MD5(source: String?, salt: String? = null): String? {
        source ?: return null
        val sourceWithSalt = salt?.plus(source) ?: source
        try {
            val hash = MessageDigest.getInstance("MD5").digest(sourceWithSalt.toByteArray(charset(CHARSET_UTF8)))
            return bytes2Hex(hash)
        } catch (e: NoSuchAlgorithmException) {
            log.error("MD5 should be supported?", e)
        } catch (e: UnsupportedEncodingException) {
            log.error("$CHARSET_UTF8 should be supported?", e)
        }
        return null
    }

    /**
     * call n MD5
     * For example,
     * if count equal 2, it will call twice MD5,  MD5(MD5(source, salt), salt)
     *
     * @param count
     * @return
     */
    fun MD5N(source: String?, salt: String? = null, count: Int): String? {
        if (count <= 0) {
            return source
        }

        var result: String? = source
        for (i in 0 until count) {
            result = MD5(result, salt)
        }
        return result
    }

    /**
     * use MD5 algorithm
     *
     * @param file the file need calculate MD5, don't support directory
     * @return the file MD5 code all in lower case
     */
    @Throws(IOException::class, NoSuchAlgorithmException::class)
    fun MD5File(file: File): String {
        // check argument
        if (!file.exists()) {
            throw FileNotFoundException(file.absolutePath + " can't be found")
        }
        if (file.isDirectory) {
            throw FileNotFoundException(file.absolutePath + " is directory")
        }

        val hash: ByteArray
        try {
            // get MD5 algorithm
            val md5 = MessageDigest.getInstance("MD5")
            // read file
            val fin = FileInputStream(file)
            //            BufferedSource source = Okio.buffer(Okio.source(file));
            val buf = ByteArray(1024)
            var count = fin.read(buf)
            while (count != -1) {
                md5.update(buf, 0, count)// update MD5
                count = fin.read(buf)
            }
            fin.close()
            hash = md5.digest()
            return bytes2Hex(hash)
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("MD5 should be supported?", e)
        }
    }

    /**
     *
     * use SHA-256 algorithm
     * @param source
     * @return
     */
    fun SHA256(source: String?, salt: String? = null): String? {
        source ?: return null
        val sourceWithSalt = salt?.plus(source) ?: source
        val messageDigest: MessageDigest
        try {
            messageDigest = MessageDigest.getInstance("SHA-256")
            messageDigest.update(sourceWithSalt.toByteArray(charset(CHARSET_UTF8)))
            return bytes2Hex(messageDigest.digest())
        } catch (e: NoSuchAlgorithmException) {
            log.error("MD5 should be supported?", e)
        } catch (e: UnsupportedEncodingException) {
            log.error("$CHARSET_UTF8 should be supported?", e)
        }
        return null
    }

    /**
     * sha256 加密 n 次
     * @param source
     * @param count
     * @return
     */
    fun SHA256N(source: String?, salt: String? = null, count: Int): String? {
        if (count <= 0) {
            return source
        }
        var result: String? = source
        for (i in 0 until count) {
            result = SHA256(result, salt)
        }
        return result
    }

    /**
     * bytes to hex string
     *
     * @param bytes
     * @return
     */
    private fun bytes2Hex(bytes: ByteArray): String {
        val stringBuilder = StringBuilder()
        var temp: String?
        for (i in bytes.indices) {
            temp = Integer.toHexString(bytes[i].toInt() and 0xFF)
            if (temp!!.length == 1) {
                stringBuilder.append("0")
            }
            stringBuilder.append(temp)
        }
        return stringBuilder.toString()
    }

}
