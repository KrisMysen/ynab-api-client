package cc.mysen

import cc.mysen.ynab.ApiClient
import java.io.File

class Context {

  fun fileStorage(): FileStorage {
    val storageFolder = File("./imported")
    return LocalFileStorage(storageFolder)
  }

  fun apiClient(): ApiClient {
    return ApiClient("get secret from path")
  }
}