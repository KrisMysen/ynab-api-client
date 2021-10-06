package cc.mysen.commandline

import java.io.BufferedReader
import java.io.InputStreamReader

class Input (

    private val inputStreamReader: InputStreamReader
        ) {
    fun read(inputReceivedListener: InputReceivedListener) {
        val bufferedReader = BufferedReader(inputStreamReader)
        val input = bufferedReader.readLine()
        inputReceivedListener.onInputReceived(input)
    }

    fun interface InputReceivedListener {

        fun onInputReceived(text: String)

    }
}
