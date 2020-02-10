package cc.mysen.transactions

import cc.mysen.files.FileEventStream
import java.io.File

class TransactionReader(private val fileEventStream: FileEventStream) {

  fun init() {
    fileEventStream.addListener{ onFileUploaded(it) }
  }

  private fun onFileUploaded(file: File) {
    println(file.name)
  }
}