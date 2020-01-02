package cc.mysen.transactions

import kotlin.test.Test
import kotlin.test.assertEquals

internal class GjensidigeTransactionReaderTest {

    @Test
    fun should_read_transaction() {
        val input = javaClass.getResourceAsStream("/gjensidige.csv")
        val transactions = GjensidigeTransactionReader().read(input)
        assertEquals(24, transactions.size , "Should be correct size")
    }

}