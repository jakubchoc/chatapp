package com.example.core.server

interface IServerThreadFactory {
	fun getServerThread(): IServerThread
}