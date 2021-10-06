package cc.mysen.files

import java.io.File

class InputFolders(
    private val rootFolderPath: String
) {

    fun get(): List<InputFolder> {
        return File(rootFolderPath).listFiles()?.map {
            InputFolder(it.name, it.path)
        } ?: emptyList()
    }

}