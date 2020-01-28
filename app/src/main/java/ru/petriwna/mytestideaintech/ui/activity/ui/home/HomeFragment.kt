package ru.petriwna.mytestideaintech.ui.activity.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_home.*
import ru.petriwna.mytestideaintech.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_collabs.setOnClickListener{
            showToastMessage("Coming soon")
        }

        btn_music.setOnClickListener{
            showToastMessage("Coming soon")
        }

        btn_bio.setOnClickListener{
            showToastMessage("Coming soon")
        }

        btn_gigs.setOnClickListener{
            showToastMessage("Coming soon")
        }
    }

    fun showToastMessage(message: String) {

        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


}