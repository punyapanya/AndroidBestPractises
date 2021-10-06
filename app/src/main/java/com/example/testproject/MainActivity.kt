package com.example.testproject

import android.os.Bundle
import com.example.testproject.databinding.ActivityMainBinding
import com.example.testproject.mvi.Action
import com.example.testproject.mvi.State
import com.example.testproject.mvi.Store
import com.example.testproject.viewbinding.ViewBindingActivity

class MainActivity : ViewBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}