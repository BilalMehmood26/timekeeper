package com.usaclean.timekeeper.ui.main.startTime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usaclean.timekeeper.databinding.ItemMyLogsBinding

class LogsAdapter(val onCLick: ()->Unit): RecyclerView.Adapter<LogsAdapter.ViewHolder> () {
    inner class ViewHolder(val binding: ItemMyLogsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMyLogsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.binding.apply {
            root.setOnClickListener {
                onCLick.invoke()
            }
        }
    }
}