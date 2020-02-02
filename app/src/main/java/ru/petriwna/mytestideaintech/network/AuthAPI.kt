package ru.petriwna.mytestideaintech.network

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import ru.petriwna.mytestideaintech.model.AvatarRespoce
import ru.petriwna.mytestideaintech.model.LoginResponse
import ru.petriwna.mytestideaintech.model.RegistrationResponce
import ru.petriwna.mytestideaintech.model.User

interface AuthAPI {

    @POST("user/register")
    fun restration(@Body user: User): Observable<RegistrationResponce>

    @POST("auth/login")
    fun login(@Body user: User): Observable<LoginResponse>

    @POST("/user/update-user-avatar")
    fun updateAvatar(@Body user: User): Observable<AvatarRespoce>


    companion object Factory {
        fun create(): AuthAPI {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://68.183.30.252:94/")
                .build()

            return retrofit.create(AuthAPI::class.java)
        }
}
}