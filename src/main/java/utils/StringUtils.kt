package utils

import java.security.MessageDigest

class StringUtils {

    companion object {

        fun applySHA256(input : String) : String {

            try {

                val digest = MessageDigest.getInstance("SHA-256")
                val hash : ByteArray = digest.digest(input.toByteArray(Charsets.UTF_8)) //encrypts input
                val hexString = StringBuilder()

                for (i in 0 until hash.size) {
                    val hex = java.lang.Integer.toHexString(0xff and hash[i].toInt())
                    if (hex.length == 1) {
                        hexString.append('0')
                    }
                    hexString.append(hex)
                }

                return  hexString.toString()
            } catch (e : Exception) {
//                "Failure"
                throw RuntimeException("Failed to encrypt the input")
            }
        }
    }

}