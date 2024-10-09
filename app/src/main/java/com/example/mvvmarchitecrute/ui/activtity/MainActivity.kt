package com.example.mvvmarchitecrute.ui.activtity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvmarchitecrute.R
import com.example.mvvmarchitecrute.data.viewModels.OnBoardingViewModel
import com.example.mvvmarchitecrute.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var navController: NavController
    private val onboardingViewModel: OnBoardingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        isOnBoardingDone()
    }

    private fun isOnBoardingDone() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        if (onboardingViewModel.isOnboardingCompleted()) {
            navController.navigate(R.id.loveCalcFragment)
        } else {
            navController.navigate(R.id.onBoardFragment)
        }
    }

//    override fun onSupportNavigateUp(): Boolean {     КОД для кнопки назад
//        val navController = findNavController(R.id.fragmentContainerView)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}