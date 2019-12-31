package cc.mysen.transactions

import kotlin.test.Test
import kotlin.test.assertTrue

internal class GjensidigeTransactionReaderTest {

    @Test
    fun should_read_transaction() {
        val input = javaClass.getResourceAsStream("/gjensidige.csv")
        val transactions = GjensidigeTransactionReader().read(input)
        assertTrue(transactions.size == 25, "Should be correct size")
    }

}