package cc.mysen.files

import java.io.InputStream
import java.time.Clock
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

interface FileStorage {

    fun save(inputStream: InputStream)

    fun createFileName(): String {
        val clock: Clock = Clock.systemUTC()
        return ZonedDateTime.ofInstant(clock.instant(), ZoneId.systemDefault())
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))
    }
}