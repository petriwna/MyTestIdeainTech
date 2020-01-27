package ru.petriwna.mytestideaintech.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_genres.view.*
import ru.petriwna.mytestideaintech.R
import ru.petriwna.mytestideaintech.model.Genre

class GenresAdapter(val list: List<Genre>, val isSkill: Boolean = false, body: () -> Unit) :
    RecyclerView.Adapter<GenresAdapter.GenreViewHolder>() {

    var context: Context? = null

    class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(g: Genre, context: Context?) {
            itemView.genres.text = g.name

            itemView.setOnClickListener {
                itemView.add.setImageDrawable(
                    context?.let { it1 ->
                        g.isCheked = !g.isCheked
                        ContextCompat.getDrawable(
                            it1, if (g.isCheked) R.drawable.add_select
                            else R.drawable.no_add_select
                        )
                    }
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(if (isSkill)R. layout.item_skillsets else R.layout.item_genres, parent, false)
        context = parent.context
        return GenreViewHolder(view)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(list[position], context)

    }
}