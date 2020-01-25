package ru.petriwna.mytestideaintech

import android.util.Patterns
import java.util.regex.Pattern

data class UserView(
    var email: String,
    var password: String) {
    constructor(): this("", "")

    fun isValidEmail(): Pattern {
        return Pattern.compile("[a-zA-Z0-9\\\\+\\\\.\\\\_\\\\%\\\\-\\\\+]{1,256}\" + \"\\\\@\" + \"[a-zA-Z0-9][a-zA-Z0-9\\\\-]{0,64}\" + \"(\" + \"\\\\.\" + \"[a-zA-Z0-9][a-zA-Z0-9\\\\-]{0,25}\" )")
    }

    fun isValidPassword():Boolean{
        var result: Boolean = false

        if (this.password.length>6||password.length<12){
            result = true
        }

        return result
    }
}