import utils.StringUtils
import java.util.Date

class Block(previousHash : String, data : String) {

    var previousHash : String = previousHash
    var data : String = data
    var timestamp : Long = Date().time
    var hash : String = calculateHash()

    private fun calculateHash() : String = StringUtils.applySHA256(previousHash + timestamp.toString() + data)





}