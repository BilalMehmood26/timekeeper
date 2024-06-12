package com.usaclean.timekeeper.ui.main.startTime

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.usaclean.timekeeper.R
import com.usaclean.timekeeper.databinding.FragmentSelectJobBinding
import com.usaclean.timekeeper.databinding.FragmentStartTimeBinding
import com.usaclean.timekeeper.databinding.FragmentTimeClockBinding
import com.usaclean.timekeeper.ui.main.home.MyLogsAdapter
import com.usaclean.timekeeper.util.inVisible
import com.usaclean.timekeeper.util.visible

class StartTimeFragment : Fragment() {

    companion object {
        fun newInstance() = StartTimeFragment()
    }


    private var _binding: FragmentStartTimeBinding? = null
    private val binding get() = _binding!!
    private lateinit var myLogsAdapter: LogsAdapter

    private lateinit var viewModel: StartTimeViewModel

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartTimeBinding.inflate(layoutInflater)
        binding.apply {
            myLogsAdapter = LogsAdapter{
                findNavController().navigate(R.id.action_startTimeFragment_to_shiftDetailsFragment)
            }
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
            myLogsRv.apply {
                adapter = myLogsAdapter
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
            }

            notesBtn.setOnClickListener {
                logsGroup.inVisible()
                notesGroup.visible()
                notesBtn.apply {
                    background.setTint(notesBtn.getResources().getColor(R.color.blue_main))
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                }
                dayLogsBtn.apply {
                    background.setTint(notesBtn.getResources().getColor(R.color.light_grey))
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                }
            }

            dayLogsBtn.setOnClickListener {
                logsGroup.visible()
                notesGroup.inVisible()
                notesBtn.apply {
                    background.setTint(notesBtn.getResources().getColor(R.color.light_grey))
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                }
                dayLogsBtn.apply {
                    background.setTint(notesBtn.getResources().getColor(R.color.blue_main))
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                }
            }
        }

        return binding.root
    }
}