import utils.StringUtils
import java.util.Date

class Block(previousHash : String, data : String) {

    var hash : String =
    var previousHash : String = previousHash
    var data : String = data
    var timestamp : Long = Date().time

    private fun calculateHash() : String {
        val hash : String = StringUtils.applySHA256(previousHash.toString() + data.toString())


    }




}