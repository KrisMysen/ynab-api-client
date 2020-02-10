package cc.mysen

import cc.mysen.transactions.TransactionReader
import org.koin.core.KoinComponent
import org.koin.core.inject

class Application : KoinComponent {

    private val api by inject<Api>()
    private val transactionReader by inject<TransactionReader>()

    fun start() {
        api.init()
        transactionReader.init()
    }
}