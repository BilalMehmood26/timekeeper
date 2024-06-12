package com.usaclean.timekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.usaclean.timekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //navController = Navigation.findNavController(this@MainActivity, R.id.container)

        binding.apply {
            homeBtn.setOnClickListener {
                homeSelected()
            }
            myRequestBtn.setOnClickListener {
                myRequestSelected()
            }

            notificationBtn.setOnClickListener {
                notificationSelected()
            }

            profileBtn.setOnClickListener {
                profileSelected()
            }
        }
    }

    private fun homeSelected() {
        binding.apply {
            findNavController(R.id.container).navigate(R.id.homeFragment2)

            homeBtn.setImageResource(R.drawable.ic_home_selected)
            myRequestBtn.setImageResource(R.drawable.ic_my_request_unselected)
            notificationBtn.setImageResource(R.drawable.ic_notification_unselected)
            profileBtn.setImageResource(R.drawable.ic_profile_unselected)
        }
    }


    private fun myRequestSelected() {
        binding.apply {
            findNavController(R.id.container).navigate(R.id.myRequestFragment2)

            homeBtn.setImageResource(R.drawable.ic_home_unselected)
            myRequestBtn.setImageResource(R.drawable.ic_my_request_selected)
            notificationBtn.setImageResource(R.drawable.ic_notification_unselected)
            profileBtn.setImageResource(R.drawable.ic_profile_unselected)
        }
    }


    private fun notificationSelected() {
        binding.apply {
            findNavController(R.id.container).navigate(R.id.notificationFragment2)

            homeBtn.setImageResource(R.drawable.ic_home_unselected)
            myRequestBtn.setImageResource(R.drawable.ic_my_request_unselected)
            notificationBtn.setImageResource(R.drawable.ic_notification_selected)
            profileBtn.setImageResource(R.drawable.ic_profile_unselected)
        }
    }


    private fun profileSelected() {
        binding.apply {
            findNavController(R.id.container).navigate(R.id.profileFragment2)

            homeBtn.setImageResource(R.drawable.ic_home_unselected)
            myRequestBtn.setImageResource(R.drawable.ic_my_request_unselected)
            notificationBtn.setImageResource(R.drawable.ic_notification_unselected)
            profileBtn.setImageResource(R.drawable.ic_profile_selected)
        }
    }
}