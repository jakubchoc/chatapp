package com.example

fun main(args: Array<String>) {
    var port = 8080
    if (args.isNotEmpty() && args[0] == "-port" && args.size > 1) {
        port = args[1].toIntOrNull() ?: 8080
    }
    println("Starting Server on port $port")
}