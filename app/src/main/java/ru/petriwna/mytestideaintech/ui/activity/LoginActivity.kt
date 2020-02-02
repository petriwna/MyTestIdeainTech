package ru.petriwna.mytestideaintech.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import io.paperdb.Paper
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_password
import ru.petriwna.mytestideaintech.PaperIO

import ru.petriwna.mytestideaintech.R
import ru.petriwna.mytestideaintech.model.User
import ru.petriwna.mytestideaintech.network.RepositoryProvider

class LoginActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        Paper.init(baseContext)

        fun isFormValid(): Boolean {
            val email = et_email.text.toString()
            val password = et_password.text.toString()

            if (email.isEmpty() || password.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите все данные!", Toast.LENGTH_LONG).show()
            }

            return true

        }

        btn_sign_in.setOnClickListener {

            if (isFormValid()) {
                RepositoryProvider.provideSearchRepository().login(User(email = et_email.text.toString(),
                    password = et_password.text.toString()))
                    .subscribeOn(Schedulers.io())
                    .subscribe({ result ->
                        PaperIO.saveUser(result)
                        val intent = Intent(this, EditProfileActivity::class.java)
                        startActivity(intent)
                    }, { error ->
                        error.printStackTrace()
                    })
            }else{

                return@setOnClickListener
            }

        }

        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        tv_forgot_password.setOnClickListener {
            val text = "Coming soon"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

    }




}
