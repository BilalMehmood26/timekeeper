package com.usaclean.timekeeper.ui.main.shiftDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.usaclean.timekeeper.R
import com.usaclean.timekeeper.databinding.FragmentShiftDetailsBinding
import com.usaclean.timekeeper.databinding.FragmentStartTimeBinding

class ShiftDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = ShiftDetailsFragment()
    }

    private var _binding: FragmentShiftDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ShiftDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShiftDetailsBinding.inflate(layoutInflater)
        binding.apply {

            endShiftBtn.setOnClickListener {
                findNavController().navigate(R.id.action_shiftDetailsFragment_to_editShiftFragment)
            }
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

}