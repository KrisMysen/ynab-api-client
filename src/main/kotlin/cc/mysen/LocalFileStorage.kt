package cc.mysen

import java.io.File
import java.io.InputStream
import java.nio.file.Files

class LocalFileStorage(private val storageFolder: File) : FileStorage {

  override fun save(inputStream: InputStream) {
    val targetFile = File("${storageFolder.path}/${createFileName()}")
    Files.copy(inputStream, targetFile.toPath())
  }

}