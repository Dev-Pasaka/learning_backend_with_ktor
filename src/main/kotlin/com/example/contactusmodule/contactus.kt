package com.example.contactusmodule

import com.example.model.UserInfo
import com.example.model.UserResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Route.contactUsModule(){
    get("/contactus"){
        call.respondText("Contact us")
        println("URI: ${call.request.uri}") //uri
        println("Headers: ${call.request.headers.names()}") //headers
        println("Query Params: ${call.request.queryParameters.names()}")
        println("Name: ${call.request.queryParameters["name"]}")
        println("Email: ${call.request.queryParameters["email"]}")
    }
    get("/aboutus"){
        call.respondText("About us")
    }
    get("iphones/{page}"){
        val pageNumber = call.parameters["page"]
        call.respondText("You are on Page number: $pageNumber")
    }
    get("/login"){
        val userInfo = call.receive<UserInfo>()
        println(userInfo)
        call.respondText("Everything is working.$userInfo")
    }
    get("/sendInfo"){
        val filePath = File(
            "/home/dev-pasaka/Downloads/ktor-sample(1)/src/main/kotlin/com/example/files/image2.jpg"
        )
        val responseObject = UserResponse("Pasaka","dev.pasaka@gmail.com","filePath")
        call.respond(responseObject)
    }
    get("/headers"){
        call.response.headers.append("server-name","Ktor-Server")
        call.respondText ("headers attached")
    }
    get("/fileDownload"){
        val filePath = File(
            "/home/dev-pasaka/Downloads/ktor-sample(1)/src/main/kotlin/com/example/files/image2.jpg"
        )
        call.response.header(
            HttpHeaders.ContentDisposition,
            ContentDisposition.Attachment.withParameter(
                ContentDisposition.Parameters.FileName,"DownloadableImage.jpg"
            ).toString()
        )

        call.respondFile(filePath)
    }
    get("/openImage"){
        val filePath = File(
            "/home/dev-pasaka/Downloads/ktor-sample(1)/src/main/kotlin/com/example/files/image1.jpg"
        )
        call.response.header(
            HttpHeaders.ContentDisposition,
            ContentDisposition.Inline.withParameter(
                ContentDisposition.Parameters.FileName,"openImage.jpg"
            ).toString()
        )

        call.respondFile(filePath)
    }



}