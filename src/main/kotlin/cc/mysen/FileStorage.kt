package cc.mysen

import java.io.InputStream
import java.time.Clock
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

interface FileStorage {

    fun save(inputStream: InputStream)

    fun createFileName(): String {
        val clock: Clock = Clock.systemUTC()
        return ZonedDateTime.from(clock.instant()).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }
}