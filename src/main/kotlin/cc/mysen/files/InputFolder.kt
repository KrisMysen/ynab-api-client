package cc.mysen.files

import java.io.File

data class InputFolder(
    val name: String,
    val path: String
) {

    fun getFiles(): List<File> {
        return File(path).listFiles()?.map { it } ?: emptyList()
    }
}