package ru.petriwna.mytestideaintech.model

import com.google.gson.annotations.SerializedName

data class User (
    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("password")
    val pasword: String? = null,

    @field:SerializedName("firstname")
    val firstname: String? = null,

    @field:SerializedName("lastname")
    val lastname: String? = null

)