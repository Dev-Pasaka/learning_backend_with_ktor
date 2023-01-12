package com.example.plugins

import com.example.contactusmodule.contactUsModule
import com.example.homeRoute
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        homeRoute()
        contactUsModule()
    }
}
