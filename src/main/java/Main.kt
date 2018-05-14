
import com.google.gson.GsonBuilder
import commons.Block
import commons.Chain
import proof.ChainValidator


fun main(args : Array<String>) {

    val blockchain = Chain.blockchain

    blockchain.add(Block("Ima first", "0"))
    blockchain[0].mineBlock(Chain.difficulty)

    blockchain.add(Block("Ima second", blockchain.last().hash))
    blockchain[1].mineBlock(Chain.difficulty)

    blockchain.add(Block("Ima third", blockchain.last().hash))
    blockchain[2].mineBlock(Chain.difficulty)

    println("Blockchain is valid: " + ChainValidator.isChainValid())

    val chainJson : String = GsonBuilder().setPrettyPrinting().create().toJson(blockchain)
    println("BLOCKCHAIN:")
    println(chainJson)



}