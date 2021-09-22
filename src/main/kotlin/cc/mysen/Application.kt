package cc.mysen

import cc.mysen.properties.ApplicationProperties
import cc.mysen.transactions.TransactionReader
import org.koin.core.KoinComponent
import org.koin.core.inject

class Application : KoinComponent {

    private val api by inject<Api>()
    private val transactionReader by inject<TransactionReader>()
    private val applicationProperties by inject<ApplicationProperties>()

    fun start() {
        api.init()
        transactionReader.init()
        println(applicationProperties.getSecret())
    }
}