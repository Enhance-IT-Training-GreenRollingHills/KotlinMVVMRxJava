package com.cc.kotlinmvvmrxjava.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.cc.kotlinmvvmrxjava.R
import com.cc.kotlinmvvmrxjava.databinding.ActivityMainBinding
import com.cc.kotlinmvvmrxjava.model.Result
import com.cc.kotlinmvvmrxjava.util.LogToConsole

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val fragmentTag = "Top"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)

        displayListFragment()



    }



    fun displayDetailFragment (data:Result) {
        displayFragment(DetailFragment(data))
    }

    fun displayListFragment () {
        displayFragment(ListFragment())
    }

    private fun displayFragment(fragment : Fragment) {
        LogToConsole.log("display frag : $fragment")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }


}