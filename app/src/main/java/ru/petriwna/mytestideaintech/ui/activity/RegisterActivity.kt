package ru.petriwna.mytestideaintech.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_register.*
import ru.petriwna.mytestideaintech.R
import ru.petriwna.mytestideaintech.model.User
import ru.petriwna.mytestideaintech.network.RepositoryProvider

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isPasswordValid(password: String): Boolean {
            password?.let {
                val passwordPattern = "^(?=.*[0-9])(?=\\S+$).{6,12}$"
                val passwordMatcher = Regex(passwordPattern)

                return passwordMatcher.find(password) != null
            }
        }

        fun isConfirmPasswordValid(confirmPassword: String, password: String): Boolean {
            return (password.equals(confirmPassword))
        }

        fun isFirstLastNameValidation(firstLast_name: String): Boolean {
            return firstLast_name.length < 3 || firstLast_name.length > 20
        }

        fun isFormValid(): Boolean {
            if (!isEmailValid(email = et_email.text.toString())) {
                et_email.error = ("Неверный адрес электронной почты")
                return false
            }
            if (!isPasswordValid(password = et_password.text.toString())) {
                et_password.error = "Пароль слишком слабый"
                return false
            }

            if (!isConfirmPasswordValid(
                    confirmPassword = confirm_password.text.toString(),
                    password = et_password.text.toString()
                )
            ) {
                confirm_password.error = ("Введите ваш пароль для подтверждения")
                return false
            }

            if (isFirstLastNameValidation(firstLast_name = first_last_name.text.toString())) {
                first_last_name.error = ("Введите полное имя")
                return false
            }

            return true
        }

        btn_register.setOnClickListener {
            if (isFormValid()) {
                RepositoryProvider.provideSearchRepository().restration(User(email = et_email.text.toString(),
                    password = et_password.text.toString(), firstName = first_last_name.text.toString(), lastName = first_last_name.text.toString()))
                    .subscribeOn(Schedulers.io())
                    .subscribe({ result ->
                        val intent = Intent(this, EditProfileActivity::class.java)
                        startActivity(intent)
                    }, { error ->
                        error.printStackTrace()
                    })
            } else {

                return@setOnClickListener
            }

        }

        sign_in.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

}
