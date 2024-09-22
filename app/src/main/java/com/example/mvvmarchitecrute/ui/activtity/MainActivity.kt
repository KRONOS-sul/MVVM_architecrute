package com.example.mvvmarchitecrute.ui.activtity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchitecrute.data.MainViewModel
import com.example.mvvmarchitecrute.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btnPlus.setOnClickListener {
                viewModel.increment()
            }
            btnMinus.setOnClickListener {
                viewModel.decrement()
            }
        }

        viewModel.counterData.observe(this) { data ->
            binding.tvCount.text = data.toString()
        }

        viewModel.toastData.observe(this) { showToast ->    // Здесь хранится значение = true
            if (showToast) {                                      // Если значение = true
                Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
                viewModel.toastData.value = false                 // Обнуляем значение
            }
        }

        viewModel.counterColorData.observe(this) { color ->
            binding.tvCount.setTextColor(color)
        }
    }
}