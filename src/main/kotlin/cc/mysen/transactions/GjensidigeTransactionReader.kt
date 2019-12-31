package cc.mysen.transactions

import java.io.BufferedReader
import java.io.InputStream
import java.util.stream.Collectors

class GjensidigeTransactionReader {

    fun read(input: InputStream): List<Transaction> {
        val reader = BufferedReader(input.reader())
        return reader.lines().map { Transaction("", "", 0F) }
            .collect(Collectors.toList())
    }

}