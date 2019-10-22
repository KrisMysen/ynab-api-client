package cc.mysen

import spark.kotlin.post
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import javax.servlet.MultipartConfigElement


fun main() {

    post("/api/v1/transactions", accepts = "application/json") {
        println("Got a http request!")
        val message = request.body()
        println(message)
    }

    post("/api/v1/transactions/file", accepts = "multipart/form-data") {
        request.attribute("org.eclipse.jetty.multipartConfig", MultipartConfigElement(System.getProperty("java.io.tmpdir")));

        val uploadDir = File("upload")
        uploadDir.mkdir()
        val tempFile = Files.createTempFile(uploadDir.toPath(), "", "")

        request.raw().getPart("uploaded_file").inputStream.use { input ->
            Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING) }
    }

}