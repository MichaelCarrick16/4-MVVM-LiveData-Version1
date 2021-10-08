package com.example.a4_mvvmlivedata_version1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initEvents()
    }

    private fun initEvents() {
        bt_start.setOnClickListener {
            mainViewModel.startEvent()
        }
    }



    private fun initViews() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.currentNumber.observe(this, Observer {
            tv_count.setText(it.toString())
            progress_bar.progress = it
        })
    }
}