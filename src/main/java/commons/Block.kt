package commons

import utils.StringUtils
import java.util.Date

class Block(data : String, previousHash : String) {

    var previousHash : String = previousHash
    var data : String = data
    var timestamp : Long = Date().time
    var hash : String = calculateHash()
    var nonce = 0

    fun calculateHash() : String = StringUtils.applySHA256(previousHash +
                                                                timestamp.toString() +
                                                                nonce.toString() +
                                                                data)

    fun mineBlock(dificulty : Int) {

        println("Mining block")

        val target = String(CharArray(dificulty)).replace('\u0000', '0') //Create a string with difficulty * "0"

        while (!hash.substring(0, dificulty).equals(target)) {
            nonce++
            hash = calculateHash()
        }

        println("Block mined! Hash: $hash")
    }

}