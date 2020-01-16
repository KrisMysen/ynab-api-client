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
            .filter {it.date.isNotBlank()}
            .collect(Collectors.toList())
    }

    private fun lineToTransaction(line: String): Transaction {
        return regex.matchEntire(line)?.destructured?.
            let { (date, type, payee, amount) -> Transaction(date, type.trim(), strip(payee), amount.toFloat()) }
            ?: Transaction.invalid()
    }

    private fun strip(payee: String): String {
        var trimmed = payee.replace("Til:", "")
        trimmed = trimmed.replace("Fra:", "")
        return trimmed.replace("(Betalt: [0-9]{2}\\.[0-9]{2}\\.[0-9]{2})".toRegex(), "").trim()
    }

}