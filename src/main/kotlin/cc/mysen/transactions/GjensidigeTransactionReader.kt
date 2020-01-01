package cc.mysen.transactions

import java.io.BufferedReader
import java.io.InputStream
import java.util.stream.Collectors

class GjensidigeTransactionReader {

    companion object {
        val regex = "([0-9]{2}\\.[0-9]{2}\\.[0-9]{4})\\s(.+)=\"(.+)\"\\s(-?\\d+\\.?\\d+)".toRegex()
    }


    fun read(input: InputStream): List<Transaction> {
        val reader = BufferedReader(input.reader())
        return reader.lines().map { lineToTransaction(it) }
            .collect(Collectors.toList())
    }

    private fun lineToTransaction(line: String): Transaction {
        return regex.matchEntire(line)?.destructured?.
            let { (date, type, description, amount) -> Transaction(date, description, 0F) }
            ?: Transaction.invalid()
    }


}