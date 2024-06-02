package com.example.core.server

import com.example.cmd.CmdParser
import com.example.cmd.IParameterProvider
import org.springframework.stereotype.Component

@Component
class ServerThreadFactory {

	companion object {
		const val DEFAULT_SERVER_PORT = 15378
		const val DEFAULT_MAX_CLIENTS = 3
		const val DEFAULT_WAITING_QUEUE_SIZE = 1
	}

	fun getServerThread(parameters: IParameterProvider): IServerThread {
		val port = parameters.getInteger(CmdParser.PORT, DEFAULT_SERVER_PORT)
		val maxClients = parameters.getInteger(CmdParser.CLIENTS, DEFAULT_MAX_CLIENTS)
		val maxWaitingQueue = parameters.getInteger(CmdParser.MAX_WAITING_QUEUE, DEFAULT_WAITING_QUEUE_SIZE)

		return ServerThread(port)
	}
}