package com.usaclean.timekeeper.ui.main.selectJob

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usaclean.timekeeper.databinding.ItemJobsBinding

class JobAdapter(val onCLick :() -> Unit): RecyclerView.Adapter<JobAdapter.ViewHolder> () {

    inner class ViewHolder(val binding: ItemJobsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemJobsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            root.setOnClickListener {
                onCLick.invoke()
            }
        }
    }
}