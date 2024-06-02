package com.example.server

import com.example.cmd.CmdParser
import com.example.cmd.IParameterProvider
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class CmdParserTest {

	private lateinit var parameterProvider: IParameterProvider

	companion object {
		val PARAMETERS = arrayOf("-port=6298", "-clients=5", "-max_waiting_queue=5", "name=test")
	}

	@Before
	fun setUp() {
		parameterProvider = CmdParser(PARAMETERS)
	}

	@Test
	fun getStringTest() {
		val key = "name"
		val name = "test"
		assertEquals(name, parameterProvider.getString(key))
	}

	@Test
	fun getStringNegativeTest() {
		val key = "unknown"
		val value: String = IParameterProvider.DEFAULT_STRING
		assertEquals(value, parameterProvider.getString(key))
	}

	@Test
	fun getIntegerTest() {
		val key = "port"
		val value = 6298
		assertEquals( value, parameterProvider.getInteger(key))
	}

	@Test
	fun getIntegerNegativeTest() {
		val key = "unknown"
		val value: Int = IParameterProvider.DEFAULT_INTEGER
		assertEquals(value, parameterProvider.getInteger(key))
	}
}
