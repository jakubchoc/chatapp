package com.example.cmd

class CmdParser(args: Array<String>) : IParameterProvider {

    private val parameterMap: MutableMap<String, String> = mutableMapOf()

    init {
        fillMap(args)
    }

    companion object {
        const val PORT = "port"
        const val CLIENTS = "clients"
        const val MAX_WAITING_QUEUE = "max_waiting_queue"
    }

    private fun fillMap(args: Array<String>) {
        args.forEach {
            val arg = it.replace("-", "")
            val raw = arg.split("=")
            if (raw.size == 2) {
                parameterMap[raw[0]] = raw[1]
            }
        }
    }

    override fun getString(key: String, def: String): String {
        return parameterMap[key] ?: def
    }

    override fun getInteger(key: String, def: Int): Int {
        return parameterMap[key]?.toInt() ?: def
    }
}