package com.usaclean.timekeeper.ui.main.myRequest

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
import com.usaclean.timekeeper.databinding.FragmentMyRequestBinding
import com.usaclean.timekeeper.databinding.FragmentStartTimeBinding
import com.usaclean.timekeeper.ui.main.startTime.LogsAdapter
import com.usaclean.timekeeper.util.gone
import com.usaclean.timekeeper.util.inVisible
import com.usaclean.timekeeper.util.visible

class MyRequestFragment : Fragment() {

    companion object {
        fun newInstance() = MyRequestFragment()
    }

    private lateinit var viewModel: MyRequestViewModel

    private var _binding: FragmentMyRequestBinding? = null
    private val binding get() = _binding!!

    private lateinit var pendingRequestAdapter: PendingRequestAdapter
    private lateinit var approveRequestAdapter: ApproveRequestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyRequestBinding.inflate(layoutInflater)

        binding.apply {

            addBtn.setOnClickListener {
                findNavController().navigate(R.id.action_myRequestFragment2_to_addRequestFragment)
            }
            pendingRequestAdapter = PendingRequestAdapter{
            }
            pendingRequestRv.apply {
                adapter = pendingRequestAdapter
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
            }

            approveRequestAdapter = ApproveRequestAdapter{
            }
            approveRequestRv.apply {
                adapter = approveRequestAdapter
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL, false
                )
            }

            pendingBtn.setOnClickListener {
                pendingRequestRv.visible()
                pendingCalender.visible()
                approveCalender.gone()
                approveRequestRv.gone()

                pendingBtn.apply {
                    background.setTint(pendingBtn.getResources().getColor(R.color.blue_main))
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                }
                approveBtn.apply {
                    background.setTint(approveBtn.getResources().getColor(R.color.light_grey))
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                }
            }

            approveBtn.setOnClickListener {
                pendingBtn.apply {
                    background.setTint(pendingBtn.getResources().getColor(R.color.light_grey))
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                }
                approveBtn.apply {
                    background.setTint(approveBtn.getResources().getColor(R.color.blue_main))
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                }
                pendingRequestRv.gone()
                pendingCalender.gone()
                approveCalender.visible()
                approveRequestRv.visible()
            }
        }
        return binding.root
    }
}