package ru.petriwna.mytestideaintech.network

import io.reactivex.Observable
import ru.petriwna.mytestideaintech.model.RegistrationResponce
import ru.petriwna.mytestideaintech.model.User


class Repos(val apiService: AuthAPI) {
    fun searchUsers(user: User): Observable<RegistrationResponce> {
        return apiService.restration(user)
    }
}