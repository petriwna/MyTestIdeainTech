package ru.petriwna.mytestideaintech.ui.activity.ui.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_show_link.*
import ru.petriwna.mytestideaintech.R

class ShowLinkFragment : Fragment() {

    private lateinit var sendViewModel: ShowLinkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
/*

        sendViewModel =
            ViewModelProviders.of(this).get(ShowLinkViewModel::class.java)*/
        val root = inflater.inflate(R.layout.fragment_show_link, container, false)
//        sendViewModel.text.observe(this, Observer {
//            textView.text = it
   //     web_view.loadUrl("https://www.google.com/")

//        })
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        web_view.loadUrl("https://www.google.com/")

    }
}