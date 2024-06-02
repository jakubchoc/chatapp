package com.example.cmd

interface IParameterFactory {

	fun getParameters(args: Array<String>): IParameterProvider
}