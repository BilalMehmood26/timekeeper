package com.usaclean.timekeeper.ui.main.selectJob

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
import com.usaclean.timekeeper.databinding.FragmentSelectJobBinding
import com.usaclean.timekeeper.ui.main.home.MyLogsAdapter

class SelectJobFragment : Fragment() {

    companion object {
        fun newInstance() = SelectJobFragment()
    }

    private var _binding: FragmentSelectJobBinding? = null
    private val binding get() = _binding!!

    private lateinit var frequentJobAdapter: FrequentJobAdapter
    private lateinit var jobAdapter: JobAdapter

    private lateinit var viewModel: SelectJobViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectJobBinding.inflate(layoutInflater)
        binding.apply {

            frequentJobAdapter = FrequentJobAdapter{
                findNavController().navigate(R.id.action_selectJobFragment_to_timeClockFragment)
            }
            jobAdapter = JobAdapter{
                findNavController().navigate(R.id.action_selectJobFragment_to_timeClockFragment)
            }
            mostUsedJobRv.apply {
                adapter = frequentJobAdapter
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
            }

            allJobRv.apply {
                adapter = jobAdapter
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
            }

            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        return binding.root
    }
}