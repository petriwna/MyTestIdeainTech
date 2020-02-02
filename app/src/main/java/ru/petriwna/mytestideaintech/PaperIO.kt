package ru.petriwna.mytestideaintech

import io.paperdb.Paper
import ru.petriwna.mytestideaintech.model.LoginResponse

class PaperIO {
    companion object {
        fun save(name: String, info:Any) {

            Paper.book().write(name, info)
        }

        fun saveUser(loginResponse: LoginResponse){
            save("user", loginResponse)
        }

        fun getUser():LoginResponse?{
            if (Paper.book().contains("user")) {
                return Paper.book().read<LoginResponse>("user")
            }
            return null
        }

    }
}