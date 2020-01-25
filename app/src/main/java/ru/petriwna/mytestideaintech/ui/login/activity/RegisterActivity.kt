package ru.petriwna.mytestideaintech.ui.login.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import ru.petriwna.mytestideaintech.R
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val confirmPassword = findViewById<EditText>(R.id.confirm_password)
        val firstLastName = findViewById<EditText>(R.id.first_last_name)
        val btnRegister = findViewById<Button>(R.id.btn_register)
        val signIn = findViewById<TextView>(R.id.sign_in)

        fun isEmailValid(email: String): Boolean{
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isPasswordValid(password: String): Boolean{
            password?.let {
                val passwordPattern = "^(?=.*[0-9])(?=\\S+$).{6,12}$"
                val passwordMatcher = Regex(passwordPattern)

                return passwordMatcher.find(password) != null
            }
        }

        fun isConfirmPasswordValid(confirmPassword: String, password: String):Boolean{
            return (password.equals(confirmPassword))
        }

        fun isFirstLastNameValidation(firstLastName: String): Boolean{
            return firstLastName.length<3 || firstLastName.length>20
        }

        fun isFormValid():Boolean{
            if (!isEmailValid(email = email.text.toString())){
                email.error = ("Неверный адрес электронной почты")
                return false
            }
            if (!isPasswordValid(password = password.text.toString())){
                password.error = "Пароль слишком слабый"
                return false
            }

            if (!isConfirmPasswordValid(confirmPassword = confirmPassword.text.toString(), password = password.text.toString())){
                confirmPassword.error = ("Введите ваш пароль для подтверждения")
                return false
            }

            if (isFirstLastNameValidation(firstLastName = firstLastName.text.toString())){
                firstLastName.error = ("Введите полное имя")
                return false
            }

            return true
        }

        btnRegister.setOnClickListener {
            if (!isFormValid()){
                return@setOnClickListener
            }

        }

        signIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

}
