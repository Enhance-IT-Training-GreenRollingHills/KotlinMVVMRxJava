package com.cc.kotlinmvvmrxjava.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cc.kotlinmvvmrxjava.R
import com.cc.kotlinmvvmrxjava.databinding.ListFragmentBinding
import com.cc.kotlinmvvmrxjava.model.Result
import com.cc.kotlinmvvmrxjava.util.LogToConsole
import com.cc.kotlinmvvmrxjava.viewmodel.ListViewModel

class ListFragment : Fragment(), RecyclerViewAdapter.NavigationDelegate {

    lateinit var binding : ListFragmentBinding

    val viewModel by viewModels<ListViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager

        binding.recyclerView.adapter = RecyclerViewAdapter(this)

        context?.let { viewModel.loadUserResponse(it, 6,  "US") }

        viewModel.getUserResponse().observe(viewLifecycleOwner, Observer {response ->
            LogToConsole.log("response : $response")
            val adapter = binding.recyclerView.adapter as RecyclerViewAdapter
            response?.let {
                adapter.update(it.results)

            }
        })

        /*binding.listToDetail.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.displayDetailFragment()
        }*/

    }

    override fun displayDetail(result: Result) {
        //
        val mainActivity = activity as MainActivity
        mainActivity.displayDetailFragment(result)
    }


}