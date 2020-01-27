package ru.petriwna.mytestideaintech.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

import kotlinx.android.synthetic.main.activity_select_genres.*
import ru.petriwna.mytestideaintech.R
import ru.petriwna.mytestideaintech.adapter.GenresAdapter
import ru.petriwna.mytestideaintech.model.Genre

class SelectGenresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_genres)

        val list = getGenres()

        rv_genres_list.adapter = GenresAdapter(getGenres()){}
        search.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                rv_genres_list.adapter = GenresAdapter (
                list.filter { it.name?.contains(p0.toString()) ?: false }){}
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

    }

    fun getGenres():List<Genre>{
        var genres:MutableList<Genre> = arrayListOf()
        resources.getStringArray(R.array.ganges).forEach { genres.add(Genre(it)) }
        return genres
    }

}
