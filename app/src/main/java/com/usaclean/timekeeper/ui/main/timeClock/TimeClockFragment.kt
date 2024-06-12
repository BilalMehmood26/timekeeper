package com.usaclean.timekeeper.ui.main.timeClock

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.usaclean.timekeeper.R
import com.usaclean.timekeeper.databinding.FragmentSelectJobBinding
import com.usaclean.timekeeper.databinding.FragmentTimeClockBinding

class TimeClockFragment : Fragment() {

    companion object {
        fun newInstance() = TimeClockFragment()
    }

    private lateinit var viewModel: TimeClockViewModel

    private var _binding: FragmentTimeClockBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTimeClockBinding.inflate(layoutInflater)
        binding.apply {
            timeClockBtn.setOnClickListener {
                findNavController().navigate(R.id.action_timeClockFragment_to_startTimeFragment)
            }
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        return binding.root
    }
}