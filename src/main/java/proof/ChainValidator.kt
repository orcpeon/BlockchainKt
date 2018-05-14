package proof

import commons.Block
import commons.Chain


class ChainValidator {

    companion object {
        fun isChainValid(chain : ArrayList<Block> = Chain.blockchain) : Boolean {

            var currentBlock : Block
            var previousBlock : Block

            for (i in 1 until chain.size) {

                currentBlock = chain[i]
                previousBlock = chain[i-1]

                if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                    println("Current block's hash is invalid")
                    return false
                }

                if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                    println("Previous block's hash is invalid")
                }

            }

            return true

        }
    }

}