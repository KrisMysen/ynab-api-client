package cc.mysen.files

import java.io.File

class FileEventStream {

  private var listeners: List<FileEventListener> = emptyList()

  fun addListener(listener: FileEventListener) {
    listeners = listeners.plusElement(listener)
  }

  fun triggerUploadedFile(file: File) {
    listeners.stream().forEach {
      it(file)
    }
  }



}