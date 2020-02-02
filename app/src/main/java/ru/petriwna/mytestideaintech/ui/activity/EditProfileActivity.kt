package ru.petriwna.mytestideaintech.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_profile.*
import ru.petriwna.mytestideaintech.R

class EditProfileActivity : AppCompatActivity() {

    private val CAMERA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        iv_avatar.setOnClickListener {
            val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA)
        }

        btn_select_skill.setOnClickListener {
            val intent = Intent(this, SelectSkillsetsActivity::class.java)
            startActivity(intent)
        }

        btn_select_genres.setOnClickListener {
            val intent = Intent(this, SelectGenresActivity::class.java)
            startActivity(intent)
        }
    }

}
