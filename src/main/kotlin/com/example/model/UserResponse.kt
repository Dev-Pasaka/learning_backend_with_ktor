package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(val name:String, val email:String,val path:String)
