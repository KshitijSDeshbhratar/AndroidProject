package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var number_txt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number_txt = findViewById(R.id.number_txt)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.startTimer()
        viewModel.seconds().observe(this,Observer{
            number_txt.text = it.toString()
        })




    }
}