package com.example.portifolio.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.portifolio.R
import com.example.portifolio.viewmodel.MainViewModel
import com.example.portifolio.databinding.FragmentHomeBinding
import com.example.portifolio.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
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

        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        userAdapter = UserAdapter()
        binding.recyclerView.adapter = userAdapter
//        setHasFixedSize(true)

    }

    private fun setupViewModel(){
        postViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        postViewModel.getPost()
        postViewModel.response.observe(requireActivity(), Observer { users : List<User>->
            updateList(users)
        })
    }

    private fun updateList(orders: List<User>){
        if (orders.isEmpty()) {
            binding.recyclerView.visibility = View.GONE
        } else {
            binding.recyclerView.visibility = View.VISIBLE
            userAdapter.updateList(orders)
        }
    }
}