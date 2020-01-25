package ru.petriwna.mytestideaintech

import io.paperdb.Paper

class PaperIO {
    companion object {
        fun save(name: String, info:String) {
            Paper.book().write(name, info)
        }
    }
}