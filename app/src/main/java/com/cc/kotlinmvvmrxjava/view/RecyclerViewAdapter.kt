package com.cc.kotlinmvvmrxjava.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cc.kotlinmvvmrxjava.databinding.ItemViewBinding
import com.cc.kotlinmvvmrxjava.model.Result

class RecyclerViewAdapter (
    private val delegate:NavigationDelegate
) : RecyclerView.Adapter<RecyclerViewAdapter.NameHolder>() {

    private var list = emptyList<Result>()

    //private var delegate:NavigationDelegate? = delegate

    interface NavigationDelegate {
        fun displayDetail(result: Result)
    }

    inner class NameHolder(binding:ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        val firstName = binding.firstName
        val lastName = binding.lastName

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        //TODO("Not yet implemented")
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NameHolder(binding)
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return list.size
    }

    override fun onBindViewHolder(holder: NameHolder, position: Int) {
        //TODO("Not yet implemented")
        val data = list[position]
        holder.firstName.text = data.name.first
        holder.lastName.text = data.name.last

        holder.itemView.setOnClickListener {
            delegate.displayDetail(data)
        }
    }

    fun update (list:List<Result>) {
        this.list = list
        notifyDataSetChanged()

    }

}