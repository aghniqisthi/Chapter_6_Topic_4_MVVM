package com.example.chapter6topic4mvvp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter6topic4mvvp.R
import com.example.chapter6topic4mvvp.databinding.ActivityMainBinding
import com.example.chapter6topic4mvvp.viewmodel.ViewModelCars

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showData()

    }

    override fun onResume() {
        super.onResume()
        showData()
    }

    fun showData(){
        val viewModel = ViewModelProvider(this).get(ViewModelCars::class.java)
        viewModel.getLDCar().observe(this, Observer {
            if (it != null) {
                val viewModel = ViewModelProvider(this).get(ViewModelCars::class.java)
                viewModel.getLDCar().observe(this, Observer {
                    if (it != null){
                        binding.rvCar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

                        val adapter = CarAdapter(it)
                        binding.rvCar.adapter = adapter
                    }
                })
                viewModel.callApiCar()
            }
            else {
                Toast.makeText(this, "There is no data to show", Toast.LENGTH_SHORT).show()
            }
        })
    }
}