package ru.petriwna.mytestideaintech.network

object   RepositoryProvider {
    fun provideSearchRepository(): AuthAPI{
        return AuthAPI.create()
    }
}