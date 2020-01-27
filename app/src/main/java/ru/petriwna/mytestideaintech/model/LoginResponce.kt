package ru.petriwna.mytestideaintech.model

import com.google.gson.annotations.SerializedName

class LoginResponce (
    @field:SerializedName("email")
    val statusCode :String? = null,

    @field:SerializedName("message")
    val message: String? = null)