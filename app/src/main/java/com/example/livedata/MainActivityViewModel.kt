package com.example.livedata

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {

  private  lateinit var timer:CountDownTimer

  var finished= MutableLiveData<Boolean>()

  private var _seconds = MutableLiveData<Int>()


  fun seconds(): LiveData<Int>{
    return _seconds
  }

    fun startTimer(){
      timer = object  : CountDownTimer(10000,1000){
        override fun onTick(p0: Long) {
          val timeLeft= p0/1000
          _seconds.value = timeLeft.toInt()
        }

        override fun onFinish() {

        }

      }.start()
    }

  fun stopTimer(){
    timer.cancel()
  }

}