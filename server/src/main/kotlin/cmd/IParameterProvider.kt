package com.example.cmd

abstract class IParameterProvider {

    companion object {
        const val DEFAULT_STRING: String = ""
        const val DEFAULT_INTEGER: Int = -1
    }

    fun getString(key: String): String {
        return getString(key, DEFAULT_STRING)
    }

    abstract fun getString(key: String, def: String): String

    fun getInteger(key: String): Int {
        return getInteger(key, DEFAULT_INTEGER)
    }

    abstract fun getInteger(key: String, def: Int): Int

}