package cc.mysen.commandline

import java.io.OutputStreamWriter
import java.nio.charset.Charset

class Output (
        private val writer: OutputStreamWriter
) {

    fun newLine() {
        write("")
    }

    fun write(text: String) {
        writer.write("${text}\n")
        writer.flush()
    }

}