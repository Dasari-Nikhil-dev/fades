package com.example.fades.ui.theme.feed

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fades.R

class FeedFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val feed = arguments?.getString("type")
        val rootView = inflater.inflate(R.layout.fragment_feed,container,false)
        feed.let {
            rootView.findViewById<TextView>(R.id.feed_text).text = it
        }
        return rootView
    }
}