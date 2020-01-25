package ru.petriwna.mytestideaintech.ui.login.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

import ru.petriwna.mytestideaintech.R

class LoginActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val userName = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val btnSignIn = findViewById<Button>(R.id.btn_sign_in)
        val forgotPassword = findViewById<TextView>(R.id.forgot_password)
        var register = findViewById<TextView>(R.id.register)

        btnSignIn.setOnClickListener {
            val userName = userName.text.toString()
            val password = password.text.toString()

            if (userName.isEmpty() || password.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите все данные!", Toast.LENGTH_LONG).show()
            }
        }

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener {
            val text = "Coming soon"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

    }


}
