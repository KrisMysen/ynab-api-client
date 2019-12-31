package cc.mysen

import java.io.File

class Context {

  fun fileStorage(): FileStorage {
    val storageFolder = File("./imported")
    return LocalFileStorage(storageFolder)
  }
}