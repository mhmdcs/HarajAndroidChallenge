package com.example.harajtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.harajtask.databinding.ActivityMainBinding

//https://git.io/JStXV json file
//use method to convert epoch timestamp to human-readable date https://www.epochconverter.com/

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setContentView(binding.root)
    }
}