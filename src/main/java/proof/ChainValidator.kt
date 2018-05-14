package proof

import commons.Block
import commons.Chain
import commons.Chain.Companion.difficulty


class ChainValidator {

    companion object {
        fun isChainValid(chain : ArrayList<Block> = Chain.blockchain) : Boolean {

            var currentBlock : Block
            var previousBlock : Block
            val hashTarget = String(CharArray(difficulty)).replace('\u0000', '0')

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

                if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                    println("This block hasn't been mined!")
                    return false
                }

            }

            return true

        }
    }

}