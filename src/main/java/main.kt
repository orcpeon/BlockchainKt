
import com.google.gson.GsonBuilder
import commons.Block
import commons.Chain


fun main(args : Array<String>) {

    val blockchain = Chain.blockchain

    blockchain.add(Block("Ima first", "0"))
    blockchain.add(Block("Ima second", blockchain.last().hash))
    blockchain.add(Block("Ima third", blockchain.last().hash))

    val chainJson : String = GsonBuilder().setPrettyPrinting().create().toJson(blockchain)

    println(chainJson)

}