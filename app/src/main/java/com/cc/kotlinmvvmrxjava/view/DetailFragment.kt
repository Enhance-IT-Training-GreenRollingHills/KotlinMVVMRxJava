package com.cc.kotlinmvvmrxjava.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cc.kotlinmvvmrxjava.databinding.DetailFragmentBinding
import com.cc.kotlinmvvmrxjava.model.Result

class DetailFragment (
    private val data : Result
) : Fragment() {

    private lateinit var binding : DetailFragmentBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailInfo.text = data.email

        binding.detailToList.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.displayListFragment()
        }

    }

}