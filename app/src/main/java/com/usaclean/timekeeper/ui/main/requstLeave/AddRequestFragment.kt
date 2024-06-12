package com.usaclean.timekeeper.ui.main.requstLeave

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.usaclean.timekeeper.R
import com.usaclean.timekeeper.databinding.FragmentAddRequestBinding
import com.usaclean.timekeeper.databinding.FragmentMyRequestBinding

class AddRequestFragment : Fragment() {

    companion object {
        fun newInstance() = AddRequestFragment()
    }

    private lateinit var viewModel: AddRequestViewModel


    private var _binding: FragmentAddRequestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddRequestBinding.inflate(layoutInflater)

        binding.apply {
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
        }
        return binding.root
    }
}