package cc.mysen

import spark.kotlin.post
import javax.servlet.MultipartConfigElement

fun main() {

    val context = Context()

    post("/api/v1/transactions/file", accepts = "multipart/form-data") {
        request.attribute("org.eclipse.jetty.multipartConfig", MultipartConfigElement(System.getProperty("java.io.tmpdir")));
        request.raw().getPart("uploaded_file")
            .inputStream.use(context.fileStorage()::save)
    }

}