package com.usaclean.timekeeper.ui.main.selectJob

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usaclean.timekeeper.databinding.ItemJobsBinding

class FrequentJobAdapter(val onCLick :() -> Unit)  : RecyclerView.Adapter<FrequentJobAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemJobsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            root.setOnClickListener {
                onCLick.invoke()
            }
        }
    }

    inner class ViewHolder(val binding: ItemJobsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}