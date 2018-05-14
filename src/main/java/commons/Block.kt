package commons

import utils.StringUtils
import java.util.Date

class Block(data : String, previousHash : String) {

    var previousHash : String = previousHash
    var data : String = data
    var timestamp : Long = Date().time
    var hash : String = calculateHash()

    fun calculateHash() : String = StringUtils.applySHA256(previousHash + timestamp.toString() + data)

}