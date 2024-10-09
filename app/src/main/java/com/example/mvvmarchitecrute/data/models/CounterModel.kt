package com.example.mvvmarchitecrute.data.models

import javax.inject.Inject

class CounterModel @Inject constructor(){

    var count = 0

    fun increment() {
        ++count
    }

    fun decrement() {
        --count
    }

}