package com.usaclean.timekeeper.ui.main.myRequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usaclean.timekeeper.databinding.ItemApproveRequestBinding
import com.usaclean.timekeeper.databinding.ItemRequestBinding

class ApproveRequestAdapter(val onCLick: ()->Unit): RecyclerView.Adapter<ApproveRequestAdapter.ViewHolder> ()  {
    inner class ViewHolder(val binding: ItemApproveRequestBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemApproveRequestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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