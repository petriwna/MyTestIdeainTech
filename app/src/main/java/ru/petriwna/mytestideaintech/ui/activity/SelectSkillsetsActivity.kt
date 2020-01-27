package ru.petriwna.mytestideaintech.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ru.petriwna.mytestideaintech.R

import kotlinx.android.synthetic.main.activity_select_skillsets.*

import ru.petriwna.mytestideaintech.adapter.GenresAdapter
import ru.petriwna.mytestideaintech.model.Genre

class SelectSkillsetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_skillsets)

        val list = getSkills()

        rv_skill_list.adapter = GenresAdapter(getSkills(), true){}
        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                rv_skill_list.adapter = GenresAdapter (
                    list.filter { it.name?.toLowerCase()?.contains(search.text.toString().toLowerCase()) ?: false }, true){}
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    fun getSkills():List<Genre>{
        var skillsets:MutableList<Genre> = arrayListOf()
        resources.getStringArray(R.array.skillsets).forEach { skillsets.add(Genre(it)) }
        return skillsets
    }

}
