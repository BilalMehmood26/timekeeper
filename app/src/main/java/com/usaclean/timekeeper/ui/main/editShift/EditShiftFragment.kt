package com.usaclean.timekeeper.ui.main.editShift

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.usaclean.timekeeper.R
import com.usaclean.timekeeper.databinding.FragmentEditShiftBinding
import com.usaclean.timekeeper.databinding.FragmentTimeClockBinding

class EditShiftFragment : Fragment() {

    companion object {
        fun newInstance() = EditShiftFragment()
    }

    private lateinit var viewModel: EditShiftViewModel

    private var _binding: FragmentEditShiftBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditShiftBinding.inflate(layoutInflater)
        binding.apply {
            approvalBtn.setOnClickListener {
                findNavController().navigate(R.id.action_editShiftFragment_to_startTimeFragment2)
            }
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditShiftViewModel::class.java)
        // TODO: Use the ViewModel
    }

}