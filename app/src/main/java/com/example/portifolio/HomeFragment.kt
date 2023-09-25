package com.example.portifolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidflow.Models.MovieResponse
import com.example.androidflow.viewmodel.MainViewModel
import com.example.portifolio.adapter.PostAdapter
import com.example.portifolio.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
//    private val postViewModel: MainViewModel by viewModels()
    private lateinit var postViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        setUi()
        postViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        postViewModel.getPost()
        postViewModel.response.observe(requireActivity(), Observer { response ->
//            postAdapter.setData(response as ArrayList<MovieResponse>)
        })
    }

    private fun setUi() {
        recyclerView = binding!!.recyclerView
        postAdapter = PostAdapter(requireActivity(), ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = postAdapter
        }
    }
}