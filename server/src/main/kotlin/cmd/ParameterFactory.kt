package com.example.cmd

import org.springframework.stereotype.Component

@Component
class ParameterFactory : IParameterFactory {

	override fun getParameters(args: Array<String>): IParameterProvider {
		return CmdParser(args)
	}
}