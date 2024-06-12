package com.usaclean.timekeeper.ui.main.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.usaclean.timekeeper.R
import com.usaclean.timekeeper.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var myLogsAdapter: MyLogsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.apply {

            myLogsAdapter = MyLogsAdapter{
                findNavController().navigate(R.id.action_homeFragment2_to_shiftDetailsFragment)
            }
            logsRv.apply {
                adapter = myLogsAdapter
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
            }

            timeClockBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment2_to_selectJobFragment)
            }

        }

        return binding.root
    }
}