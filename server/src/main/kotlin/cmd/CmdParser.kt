package com.example.cmd

class CmdParser {

    init {
        fillMap()
    }

    companion object {
        const val PORT = "port"
        const val CLIENTS = "clients"
        const val MAX_WAITING_QUEUE = "max_waiting_queue"
    }

    var map = HashMap<String, String>()

    private fun fillMap(args: Array<String>) {
        args.forEach {
            val arg = it.replace("-", "")
            val raw = arg.split("=")
            map[raw[0]] = raw[1]
        }
    }
}