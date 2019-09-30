package cc.mysen

import spark.kotlin.post

fun main() {

    post("/api/v1/transactions", accepts = "application/json") {
        println("Got a http request!")
        val message = request.body()
        println(message)
    }

}