package com.example

import com.example.cmd.CmdParser
import com.example.cmd.ParameterFactory
import com.example.core.server.ServerThreadFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Server(
	private val parameterFactory: ParameterFactory,
	private val serverThreadFactory: ServerThreadFactory,
) {

	fun run(args: Array<String>) {
		val parameters = parameterFactory.getParameters(args)
		val serverThread = serverThreadFactory.getServerThread(parameters)
		val scanner = java.util.Scanner(System.`in`)
		serverThread.start()
		while (true) {
			val input = scanner.nextLine()
			if (input == "exit") {
				break
			}
		}
		serverThread.shutDown()

		println("Server started on port: ${parameters.getInteger(CmdParser.PORT)}")
		println("Maximum number of clients: ${parameters.getInteger(CmdParser.CLIENTS)}")
		println("Maximum number of clients waiting in queue: ${parameters.getInteger(CmdParser.MAX_WAITING_QUEUE)}")
	}
}

fun main(args: Array<String>) {
	val context = runApplication<Server>(*args)
	val server = context.getBean(Server::class.java)
	server.run(args)
}

//mvn spring-boot:run -pl server -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005" -Dspring-boot.run.arguments="--port=6298 --clients=5 --max_waiting_queue=10"
//mvn spring-boot:run -pl server -Dspring-boot.run.arguments="--port=6298 --clients=5 --max_waiting_queue=10"