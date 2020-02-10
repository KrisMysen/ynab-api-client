package cc.mysen.files

import java.io.File
import java.io.InputStream

class LocalFileStorage(
  private val storageFolder: File,
  private val fileEventStream: FileEventStream
) : FileStorage {

  override fun save(inputStream: InputStream) {
    if (!storageFolder.exists()) {
      storageFolder.mkdirs()
    }
    val targetFile = File("${storageFolder.path}\\${createFileName()}")
    targetFile.outputStream().use { out ->
      inputStream.copyTo(out)
    }
    fileEventStream.triggerUploadedFile(targetFile)
  }

}