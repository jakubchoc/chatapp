package com.example.core.server

import java.io.IOException
import java.net.ServerSocket
import java.net.SocketTimeoutException

class ServerThread(
	private val port: Int
) : Thread("ServerThread"), IServerThread {

	companion object {
		const val SOCKET_TIMEOUT = 5000
	}

	//private var port = port
	private var running: Boolean = false

	override fun start() {
		try {
			val serverSocket = ServerSocket(port)
			serverSocket.setSoTimeout(SOCKET_TIMEOUT)
			running = true
			while (running) {
				try {
					val socket = serverSocket.accept()
				} catch (e: SocketTimeoutException) {
					// Do nothing
				}
			}
		} catch (e: IOException) {
			e.printStackTrace()
		}
	}

	override fun shutDown() {
		running = false
		try {
			join()
		} catch (e: InterruptedException) {
			e.printStackTrace()
		}
	}
}