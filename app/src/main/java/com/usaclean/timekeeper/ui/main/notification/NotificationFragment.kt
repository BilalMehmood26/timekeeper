package com.usaclean.timekeeper.ui.main.notification

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.usaclean.timekeeper.R
import com.usaclean.timekeeper.databinding.FragmentNotificationBinding
import com.usaclean.timekeeper.ui.main.home.MyLogsAdapter

class NotificationFragment : Fragment() {

    companion object {
        fun newInstance() = NotificationFragment()
    }

    private lateinit var viewModel: NotificationViewModel

    private var _binding :FragmentNotificationBinding?=null
    private val binding get() = _binding!!
    private lateinit var notificationAdapter: NotificationAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(layoutInflater)

        binding.apply {

            notificationAdapter = NotificationAdapter()
            notificationRv.apply {
                adapter = notificationAdapter
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
            }

            yestrdayNotificationRv.apply {
                adapter = notificationAdapter
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
            }
        }
        return binding.root
    }
}