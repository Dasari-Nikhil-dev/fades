package com.example.fades.ui.theme.feed

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fades.databinding.FragmentFeedBinding

class FeedFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()
    private  val feedAdapter = FeedRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val feed = arguments?.getString("type") // TODO move to Enum
        feed?.let {
            viewModel.updateFeed(it)
        }

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(inflater,container,false)
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.feedRecyclerView.adapter = feedAdapter

        viewModel.feed.observe(viewLifecycleOwner) {
            feedAdapter.submitList(it)
            /*Toast.makeText(requireContext(),"Downloaded ${it.size} images ",Toast.LENGTH_SHORT).show()*/
        }

        return binding.root
    }
}