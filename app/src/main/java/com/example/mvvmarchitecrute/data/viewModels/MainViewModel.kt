package com.example.mvvmarchitecrute.data.viewModels

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecrute.data.models.CounterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val model: CounterModel) : ViewModel() {

    val counterData = MutableLiveData<Int>()        // Значение count
    val counterColorData = MutableLiveData<Int>()   // Цвет count
    val toastData = MutableLiveData<Boolean>()      // Показывать тост

    fun increment() {
        model.increment()
        updateView()
    }

    fun decrement() {
        model.decrement()
        updateView()
    }

    private fun updateView() {
        counterData.value = model.count             // Обновляем значение count

        when (model.count) {
            10 -> toastData.value = true
            15 -> counterColorData.value = Color.GREEN
            else -> counterColorData.value = Color.BLACK
        }
    }

}