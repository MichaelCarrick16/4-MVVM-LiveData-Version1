package com.example.a4_mvvmlivedata_version1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var number : Int = 0

    val currentNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }


    fun startEvent() {
        Thread(object : Runnable{
            override fun run() {
                for (i in 1..10){
                    try {
                        Thread.sleep(500)
                    }catch (e : InterruptedException){
                        e.printStackTrace()
                    }
                    currentNumber.postValue(i)
                }
            }
        }).start()
    }

}